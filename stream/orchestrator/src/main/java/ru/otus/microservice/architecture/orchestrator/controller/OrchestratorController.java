package ru.otus.microservice.architecture.orchestrator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.microservice.architecture.orchestrator.service.BpmService;

@RestController
public class OrchestratorController {
    private final BpmService bpmService;

    @Autowired
    public OrchestratorController(BpmService bpmService) {
        this.bpmService = bpmService;
    }

    @PostMapping(path = "/order/new")
    public void start(@RequestParam(name = "orderId") String orderId, @RequestParam(name = "accountId") String accountId, @RequestParam(name = "price") Double price) {
        bpmService.start(orderId, accountId, price);
    }
}