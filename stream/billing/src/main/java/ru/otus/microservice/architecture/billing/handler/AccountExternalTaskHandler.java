package ru.otus.microservice.architecture.billing.handler;

import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.microservice.architecture.billing.model.entity.AccountEntity;
import ru.otus.microservice.architecture.billing.repository.AccountRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.Map;

@Component
@ExternalTaskSubscription("debit")
public class AccountExternalTaskHandler implements ExternalTaskHandler {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountExternalTaskHandler(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    @Transactional
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {
        String accountId = externalTask.getVariable("accountId");
        Double price = externalTask.getVariable("price");
        AccountEntity accountEntity = accountRepository.findById(accountId).orElseThrow(EntityNotFoundException::new);
        Map<String, Object> variables = Collections.singletonMap("email", accountEntity.getEmail());
        double delta = accountEntity.getMoney() - price;
        if (delta >= 0) {
            accountEntity.setMoney(delta);
            externalTaskService.complete(externalTask, variables);
        } else {
            externalTaskService.handleBpmnError(externalTask, "MONEY_ERROR", "MONEY_ERROR", variables);
        }
    }
}