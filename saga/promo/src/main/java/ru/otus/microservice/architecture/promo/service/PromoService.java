package ru.otus.microservice.architecture.promo.service;

import ru.otus.microservice.architecture.promo.model.dto.PromoDto;

public interface PromoService {
    PromoDto create(PromoDto promoDto);
    PromoDto read(String id);
    PromoDto update(String id, PromoDto promoDto);
    PromoDto delete(String id);
    void check(PromoDto promoDto);
}