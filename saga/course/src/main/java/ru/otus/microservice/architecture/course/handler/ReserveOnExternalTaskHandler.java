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

import java.util.Map;

@Component
@ExternalTaskSubscription("reserve-on")
public class ReserveOnExternalTaskHandler implements ExternalTaskHandler {
    private final CourseRepository courseRepository;

    @Autowired
    public ReserveOnExternalTaskHandler(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    @Transactional
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {
        try {
            String courseId = externalTask.getVariable("courseId");
            CourseEntity courseEntity = courseRepository.findById(courseId).orElseThrow();
            if (courseEntity.getLimit() == 0)
                throw new RuntimeException("Нет свободных мест!");
            courseEntity.setLimit(courseEntity.getLimit() - 1);
            externalTaskService.complete(externalTask, Map.of("name", courseEntity.getName(), "cost", courseEntity.getCost(), "from", courseEntity.getFrom(), "to", courseEntity.getTo()));
        } catch (Exception e) {
            externalTaskService.handleBpmnError(externalTask, "SAGA_ERROR", e.getMessage());
        }
    }
}