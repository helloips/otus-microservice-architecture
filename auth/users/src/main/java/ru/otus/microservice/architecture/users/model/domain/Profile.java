package ru.otus.microservice.architecture.users.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Profile {
    @JsonProperty(value = "fullName")
    private String fullName;
    @JsonProperty(value = "citizenship")
    private Citizenship citizenship;
    @JsonProperty(value = "age")
    private Integer age;
}