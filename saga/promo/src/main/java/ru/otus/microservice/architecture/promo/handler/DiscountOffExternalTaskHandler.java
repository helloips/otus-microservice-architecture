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

@Component
@ExternalTaskSubscription("discount-off")
public class DiscountOffExternalTaskHandler implements ExternalTaskHandler {
    private final PromoRepository promoRepository;

    @Autowired
    public DiscountOffExternalTaskHandler(PromoRepository promoRepository) {
        this.promoRepository = promoRepository;
    }

    @Override
    @Transactional
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {
        String promoId = externalTask.getVariable("promoId");
        PromoEntity promoEntity = promoRepository.findById(promoId).orElseThrow();
        promoEntity.setActive(true);
        externalTaskService.complete(externalTask);
    }
}