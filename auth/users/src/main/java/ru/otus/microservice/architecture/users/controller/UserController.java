package ru.otus.microservice.architecture.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.microservice.architecture.users.model.domain.User;
import ru.otus.microservice.architecture.users.service.AuthService;

import java.util.*;

@RestController
public class UserController {
    private final AuthService authService;

    @Autowired
    public UserController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(value = "/register")
    public Map<String, String> register(@RequestBody User user) {
        String profileId = authService.register(user);
        return Collections.singletonMap("profileId", profileId);
    }

    @PostMapping(value = "/login")
    public Map<String, String> login(@RequestBody User user) {
        String token = authService.login(user);
        return Collections.singletonMap("token", token);
    }
}