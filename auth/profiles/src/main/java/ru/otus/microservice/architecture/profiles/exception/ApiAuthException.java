package ru.otus.microservice.architecture.profiles.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiAuthException extends RuntimeException {
    private final String message;
}