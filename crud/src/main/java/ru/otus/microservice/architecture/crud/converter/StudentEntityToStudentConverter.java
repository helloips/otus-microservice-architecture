package ru.otus.microservice.architecture.crud.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.otus.microservice.architecture.crud.entity.StudentEntity;
import ru.otus.microservice.architecture.crud.model.Student;

@Component
public class StudentEntityToStudentConverter implements Converter<StudentEntity, Student> {
    @Override
    public Student convert(StudentEntity studentEntity) {
        Student student = new Student();
        student.setId(studentEntity.getId());
        student.setName(studentEntity.getName());
        student.setSurname(studentEntity.getSurname());
        student.setAge(studentEntity.getAge());
        return student;
    }
}