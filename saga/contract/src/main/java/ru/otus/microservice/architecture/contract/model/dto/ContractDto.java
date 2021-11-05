package ru.otus.microservice.architecture.contract.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContractDto {
    @JsonProperty(value = "id")
    private String id;
    @JsonProperty(value = "courseId")
    private String courseId;
    @JsonProperty(value = "promoId")
    private String promoId;
    @JsonProperty(value = "template")
    private String template;
    @JsonProperty(value = "status")
    private String status;
}