package ru.otus.microservice.architecture.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.otus.microservice.architecture.crud.model.Student;
import ru.otus.microservice.architecture.crud.service.StudentService;

@RestController
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/v1/student")
    public Student create(@RequestBody Student student) {
        return studentService.create(student);
    }

    @GetMapping("/v1/student/{id}")
    public Student read(@PathVariable(name = "id") Long id) {
        return studentService.read(id);
    }

    @PutMapping("/v1/student/{id}")
    public Student update(@PathVariable(name = "id") Long id, @RequestBody Student student) {
        student.setId(id);
        return studentService.update(student);
    }

    @DeleteMapping("/v1/student/{id}")
    public Student delete(@PathVariable(name = "id") Long id) {
        return studentService.delete(id);
    }
}
