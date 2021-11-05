package ru.otus.microservice.architecture.orchestrator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.microservice.architecture.orchestrator.service.OrchestratorService;

@RestController
public class OrchestratorController {
    private final OrchestratorService orchestratorService;

    @Autowired
    public OrchestratorController(OrchestratorService orchestratorService) {
        this.orchestratorService = orchestratorService;
    }

    @PostMapping(path = "digital/v1/orchestrator")
    public void start(@RequestParam(name = "contractId") String contractId) {
        orchestratorService.start(contractId);
    }
}