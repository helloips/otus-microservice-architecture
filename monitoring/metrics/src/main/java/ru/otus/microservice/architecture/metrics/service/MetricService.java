package ru.otus.microservice.architecture.metrics.service;

public interface MetricService {
    Long create(String name, String value);
    String read(Long id);
}