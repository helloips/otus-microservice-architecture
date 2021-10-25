package ru.otus.microservice.architecture.notification.handler;

import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.springframework.stereotype.Component;
import ru.otus.microservice.architecture.notification.model.entity.MailEntity;
import ru.otus.microservice.architecture.notification.repository.MailRepository;

@Component
@ExternalTaskSubscription("mail")
public class MailExternalTaskHandler implements ExternalTaskHandler {
    private final MailRepository mailRepository;

    public MailExternalTaskHandler(MailRepository mailRepository) {
        this.mailRepository = mailRepository;
    }

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {
        String orderId = externalTask.getVariable("orderId");
        String accountId = externalTask.getVariable("accountId");
        String email = externalTask.getVariable("email");
        String text = externalTask.getVariable("text");
        MailEntity mailEntity = new MailEntity();
        mailEntity.setOrderId(orderId);
        mailEntity.setAccountId(accountId);
        mailEntity.setEmail(email);
        mailEntity.setText(text);
        mailRepository.save(mailEntity);
        externalTaskService.complete(externalTask);
    }
}