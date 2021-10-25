package ru.otus.microservice.architecture.orchestrator.service;

public interface BpmService {
    void start(String orderId, String accountId, Double price);
}