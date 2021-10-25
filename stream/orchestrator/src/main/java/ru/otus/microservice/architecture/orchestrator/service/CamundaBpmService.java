package ru.otus.microservice.architecture.orchestrator.service;

import org.camunda.bpm.engine.ProcessEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CamundaBpmService implements BpmService {
    private final ProcessEngine processEngine;

    @Autowired
    public CamundaBpmService(ProcessEngine processEngine) {
        this.processEngine = processEngine;
    }

    @Override
    public void start(String orderId, String accountId, Double price) {
        String businessKey = String.format("process_%s_%s", orderId, accountId);
        Map<String, Object> variables = new HashMap<>();
        variables.put("orderId", orderId);
        variables.put("accountId", accountId);
        variables.put("price", price);
        processEngine
                .getRuntimeService()
                .startProcessInstanceByKey("Order", businessKey, variables);
    }
}