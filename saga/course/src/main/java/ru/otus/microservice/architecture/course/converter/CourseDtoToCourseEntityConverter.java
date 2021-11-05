package ru.otus.microservice.architecture.course.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.otus.microservice.architecture.course.model.dto.CourseDto;
import ru.otus.microservice.architecture.course.model.entity.CourseEntity;

@Component
public class CourseDtoToCourseEntityConverter implements Converter<CourseDto, CourseEntity> {
    @Override
    public CourseEntity convert(CourseDto courseDto) {
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setId(null);
        courseEntity.setName(courseDto.getName());
        courseEntity.setCost(courseDto.getCost());
        courseEntity.setLimit(courseDto.getLimit());
        courseEntity.setFrom(courseDto.getFrom());
        courseEntity.setTo(courseDto.getTo());
        return courseEntity;
    }
}