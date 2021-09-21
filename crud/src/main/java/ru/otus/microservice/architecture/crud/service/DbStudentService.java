package ru.otus.microservice.architecture.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.microservice.architecture.crud.entity.StudentEntity;
import ru.otus.microservice.architecture.crud.model.Student;
import ru.otus.microservice.architecture.crud.repository.StudentRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Objects;

@Service
public class DbStudentService implements StudentService {
    private final StudentRepository studentRepository;
    private final ConversionService conversionService;

    @Autowired
    public DbStudentService(StudentRepository studentRepository, ConversionService conversionService) {
        this.studentRepository = studentRepository;
        this.conversionService = conversionService;
    }

    @Override
    @Transactional
    public Student create(Student student) {
        StudentEntity studentEntity = conversionService.convert(student, StudentEntity.class);
        studentEntity.setId(null);
        studentRepository.save(studentEntity);
        return conversionService.convert(studentEntity, Student.class);
    }

    @Override
    @Transactional
    public Student read(Long id) {
        StudentEntity studentEntity = studentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Student not found!"));
        return conversionService.convert(studentEntity, Student.class);
    }

    @Override
    @Transactional
    public Student update(Student student) {
        StudentEntity studentEntity = studentRepository.findById(student.getId()).orElseThrow(() -> new EntityNotFoundException("Student not found!"));
        if (Objects.nonNull(student.getName()))
            studentEntity.setName(student.getName());
        if (Objects.nonNull(student.getSurname()))
            studentEntity.setSurname(student.getSurname());
        if (Objects.nonNull(student.getAge()))
            studentEntity.setAge(student.getAge());
        return conversionService.convert(studentEntity, Student.class);

    }

    @Override
    @Transactional
    public Student delete(Long id) {
        StudentEntity studentEntity = studentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Student not found!"));
        studentRepository.deleteById(id);
        return conversionService.convert(studentEntity, Student.class);
    }
}
