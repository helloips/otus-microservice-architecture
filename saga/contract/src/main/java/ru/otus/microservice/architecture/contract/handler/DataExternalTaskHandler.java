package ru.otus.microservice.architecture.contract.handler;

import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.microservice.architecture.contract.model.entity.ContractEntity;
import ru.otus.microservice.architecture.contract.repository.ContractRepository;

import java.util.Map;

@Component
@ExternalTaskSubscription("data")
public class DataExternalTaskHandler implements ExternalTaskHandler {
    private final ContractRepository contractRepository;

    @Autowired
    public DataExternalTaskHandler(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @Override
    @Transactional
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {
        String contractId = externalTask.getVariable("contractId");
        ContractEntity contractEntity = contractRepository.findById(contractId).orElseThrow();
        externalTaskService.complete(externalTask, Map.of("courseId", contractEntity.getCourseId(), "promoId", contractEntity.getPromoId()));
    }
}