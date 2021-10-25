package ru.otus.microservice.architecture.billing.model.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {
    @JsonProperty("fullName")
    private String fullName;
    @JsonProperty("money")
    private Double money;
    @JsonProperty("email")
    private String email;
}