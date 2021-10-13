package ru.otus.microservice.architecture.profiles.service;

import ru.otus.microservice.architecture.profiles.model.domain.Profile;

public interface ProfileService {
    String create(Profile profile);
    void update(String id, Profile profile);
    Profile read(String id);
}