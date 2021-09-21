package ru.otus.microservice.architecture.crud.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.otus.microservice.architecture.crud.entity.StudentEntity;
import ru.otus.microservice.architecture.crud.model.Student;

@Component
public class StudentToStudentEntityConverter implements Converter<Student, StudentEntity> {
    @Override
    public StudentEntity convert(Student student) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(student.getId());
        studentEntity.setName(student.getName());
        studentEntity.setSurname(student.getSurname());
        studentEntity.setAge(student.getAge());
        return studentEntity;
    }
}
