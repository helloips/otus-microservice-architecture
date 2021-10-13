package ru.otus.microservice.architecture.profiles.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.otus.microservice.architecture.profiles.exception.ApiAuthException;
import ru.otus.microservice.architecture.profiles.model.domain.ApiError;

import javax.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(ApiAuthException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ApiError handleApiAuthException(ApiAuthException e) {
        return new ApiError(e.getMessage());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleEntityNotFoundException(EntityNotFoundException e) {
        return new ApiError("Profile id is incorrect");
    }

    @ExceptionHandler(MissingRequestHeaderException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ApiError handleMissingRequestHeaderException(MissingRequestHeaderException e) {
        return new ApiError("Unauthorized");
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiError handleException(Exception e) {
        e.printStackTrace();
        return new ApiError("Internal server error");
    }
}