package ru.otus.microservice.architecture.orchestrator.service;

import org.camunda.bpm.engine.ProcessEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BpmOrchestratorService implements OrchestratorService {
    private final ProcessEngine processEngine;

    @Autowired
    public BpmOrchestratorService(ProcessEngine processEngine) {
        this.processEngine = processEngine;
    }

    @Override
    public void start(String contractId) {
        String businessKey = String.format("process_%s", contractId);
        Map<String, Object> variables = new HashMap<>();
        variables.put("contractId", contractId);
        variables.put("success", true);
        processEngine
                .getRuntimeService()
                .startProcessInstanceByKey("Contract", businessKey, variables);
    }
}