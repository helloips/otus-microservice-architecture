package ru.otus.microservice.architecture.course.handler;

import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.microservice.architecture.course.model.entity.CourseEntity;
import ru.otus.microservice.architecture.course.repository.CourseRepository;

@Component
@ExternalTaskSubscription("reserve-off")
public class ReserveOffExternalTaskHandler implements ExternalTaskHandler {
    private final CourseRepository courseRepository;

    @Autowired
    public ReserveOffExternalTaskHandler(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    @Transactional
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {
        String courseId = externalTask.getVariable("courseId");
        CourseEntity courseEntity = courseRepository.findById(courseId).orElseThrow();
        courseEntity.setLimit(courseEntity.getLimit() + 1);
        externalTaskService.complete(externalTask);
    }
}