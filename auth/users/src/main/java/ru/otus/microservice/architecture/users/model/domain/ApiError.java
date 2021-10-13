package ru.otus.microservice.architecture.users.model.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiError {
    @JsonProperty(value = "errorMessage")
    private final String errorMessage;
}