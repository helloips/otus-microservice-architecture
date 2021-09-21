package ru.otus.microservice.architecture.crud.service;

import ru.otus.microservice.architecture.crud.model.Student;

public interface StudentService {
    Student create(Student student);
    Student read(Long id);
    Student update(Student student);
    Student delete(Long id);
}
