package ru.otus.microservice.architecture.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.microservice.architecture.course.model.dto.CourseDto;
import ru.otus.microservice.architecture.course.model.entity.CourseEntity;
import ru.otus.microservice.architecture.course.repository.CourseRepository;

@Service
public class DbCourseService implements CourseService {
    private final CourseRepository courseRepository;
    private final ConversionService conversionService;

    @Autowired
    public DbCourseService(CourseRepository courseRepository, ConversionService conversionService) {
        this.courseRepository = courseRepository;
        this.conversionService = conversionService;
    }

    @Override
    @Transactional
    public CourseDto create(CourseDto courseDto) {
        CourseEntity courseEntity = conversionService.convert(courseDto, CourseEntity.class);
        courseRepository.save(courseEntity);
        return conversionService.convert(courseEntity, CourseDto.class);
    }

    @Override
    @Transactional
    public CourseDto read(String id) {
        CourseEntity courseEntity = courseRepository.findById(id).orElseThrow();
        return conversionService.convert(courseEntity, CourseDto.class);
    }

    @Override
    @Transactional
    public CourseDto update(String id, CourseDto courseDto) {
        CourseEntity courseEntity = courseRepository.findById(id).orElseThrow();
        courseEntity.setName(courseDto.getName());
        courseEntity.setCost(courseDto.getCost());
        courseEntity.setLimit(courseDto.getLimit());
        courseEntity.setFrom(courseDto.getFrom());
        courseEntity.setTo(courseDto.getTo());
        return conversionService.convert(courseEntity, CourseDto.class);
    }

    @Override
    @Transactional
    public CourseDto delete(String id) {
        CourseEntity courseEntity = courseRepository.findById(id).orElseThrow();
        CourseDto courseDto = conversionService.convert(courseEntity, CourseDto.class);
        courseRepository.deleteById(id);
        return courseDto;
    }
}