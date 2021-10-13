package ru.otus.microservice.architecture.users.service;

import ru.otus.microservice.architecture.users.model.domain.User;

public interface AuthService {
    String register(User user);
    String login(User user);
}