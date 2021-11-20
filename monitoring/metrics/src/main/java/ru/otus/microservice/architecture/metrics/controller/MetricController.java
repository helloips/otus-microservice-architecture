package ru.otus.microservice.architecture.metrics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.otus.microservice.architecture.metrics.service.MetricService;

@RestController
public class MetricController {
    private final MetricService metricService;

    @Autowired
    public MetricController(MetricService metricService) {
        this.metricService = metricService;
    }

    @PostMapping(path = "/metrics")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Long create(@RequestParam(name = "name") String name, @RequestParam(name = "value") String value) {
        return metricService.create(name, value);
    }

    @GetMapping(path = "/metrics/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public String read(@PathVariable(name = "id") Long id) {
        return metricService.read(id);
    }
}