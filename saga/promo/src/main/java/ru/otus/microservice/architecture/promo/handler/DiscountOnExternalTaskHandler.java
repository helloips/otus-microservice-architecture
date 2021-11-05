package ru.otus.microservice.architecture.promo.handler;

import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.microservice.architecture.promo.model.entity.PromoEntity;
import ru.otus.microservice.architecture.promo.repository.PromoRepository;

import java.util.Map;

@Component
@ExternalTaskSubscription("discount-on")
public class DiscountOnExternalTaskHandler implements ExternalTaskHandler {
    private final PromoRepository promoRepository;

    @Autowired
    public DiscountOnExternalTaskHandler(PromoRepository promoRepository) {
        this.promoRepository = promoRepository;
    }

    @Override
    @Transactional
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {
        try {
            String promoId = externalTask.getVariable("promoId");
            Double cost = externalTask.getVariable("cost");
            PromoEntity promoEntity = promoRepository.findById(promoId).orElseThrow();
            promoEntity.setActive(false);
            cost = cost * (promoEntity.getDiscount() / 100);
            externalTaskService.complete(externalTask, Map.of("cost", cost));
        } catch (Exception e) {
            externalTaskService.handleBpmnError(externalTask, "SAGA_ERROR", e.getMessage());
        }
    }
}