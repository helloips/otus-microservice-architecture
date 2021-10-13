package ru.otus.microservice.architecture.profiles.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Profile {
    @JsonProperty(value = "fullName")
    private String fullName;
    @JsonProperty(value = "citizenship")
    private Citizenship citizenship;
    @JsonProperty(value = "age")
    private Integer age;
}