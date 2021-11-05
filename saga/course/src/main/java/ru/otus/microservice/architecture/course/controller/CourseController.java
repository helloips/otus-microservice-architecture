package ru.otus.microservice.architecture.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.otus.microservice.architecture.course.model.dto.CourseDto;
import ru.otus.microservice.architecture.course.service.CourseService;

@RestController
public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("digital/v1/course")
    @ResponseStatus(value = HttpStatus.CREATED)
    public CourseDto create(@RequestBody CourseDto courseDto) {
        return courseService.create(courseDto);
    }

    @GetMapping("digital/v1/course/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public CourseDto read(@PathVariable(name = "id") String id) {
        return courseService.read(id);
    }

    @PatchMapping("digital/v1/course/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public CourseDto update(@PathVariable(name = "id") String id, @RequestBody CourseDto courseDto) {
        return courseService.update(id, courseDto);
    }

    @DeleteMapping("digital/v1/course/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public CourseDto delete(@PathVariable(name = "id") String id) {
        return courseService.delete(id);
    }
}