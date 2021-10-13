package ru.otus.microservice.architecture.profiles.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.otus.microservice.architecture.profiles.model.entity.ProfileEntity;

@Repository
public interface ProfileRepository extends CrudRepository<ProfileEntity, String> {
}