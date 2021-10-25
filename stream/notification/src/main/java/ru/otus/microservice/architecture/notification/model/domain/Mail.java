package ru.otus.microservice.architecture.notification.model.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Mail {
    @JsonProperty(value = "accountId")
    private String accountId;
    @JsonProperty(value = "orderId")
    private String orderId;
    @JsonProperty(value = "email")
    private String email;
    @JsonProperty(value = "text")
    private String text;
}