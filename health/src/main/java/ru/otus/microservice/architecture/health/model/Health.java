package ru.otus.microservice.architecture.health.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Health {
    @JsonProperty("status")
    private final Status status;
}
