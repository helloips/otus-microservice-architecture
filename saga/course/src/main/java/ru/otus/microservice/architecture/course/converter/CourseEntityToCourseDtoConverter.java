package ru.otus.microservice.architecture.course.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.otus.microservice.architecture.course.model.dto.CourseDto;
import ru.otus.microservice.architecture.course.model.entity.CourseEntity;

@Component
public class CourseEntityToCourseDtoConverter implements Converter<CourseEntity, CourseDto> {
    @Override
    public CourseDto convert(CourseEntity courseEntity) {
        CourseDto courseDto = new CourseDto();
        courseDto.setId(courseEntity.getId());
        courseDto.setName(courseEntity.getName());
        courseDto.setCost(courseEntity.getCost());
        courseDto.setLimit(courseEntity.getLimit());
        courseDto.setFrom(courseEntity.getFrom());
        courseDto.setTo(courseEntity.getTo());
        return courseDto;
    }
}