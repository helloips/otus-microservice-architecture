package ru.otus.microservice.architecture.course.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.otus.microservice.architecture.course.model.entity.CourseEntity;

@Repository
public interface CourseRepository extends CrudRepository<CourseEntity, String> {
}