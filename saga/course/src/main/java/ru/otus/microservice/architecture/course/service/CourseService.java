package ru.otus.microservice.architecture.course.service;

import ru.otus.microservice.architecture.course.model.dto.CourseDto;

public interface CourseService {
    CourseDto create(CourseDto courseDto);
    CourseDto read(String id);
    CourseDto update(String id, CourseDto courseDto);
    CourseDto delete(String id);
}