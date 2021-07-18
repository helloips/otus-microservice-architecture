package ru.otus.microservice.architecture.health.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.microservice.architecture.health.model.Health;
import ru.otus.microservice.architecture.health.model.Status;

@RestController
@ResponseStatus(value = HttpStatus.OK)
public class HealthController {
    @GetMapping(path = "/health")
    public @ResponseBody Health getHealth() {
        return new Health(Status.OK);
    }
}
