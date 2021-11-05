package ru.otus.microservice.architecture.promo.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.otus.microservice.architecture.promo.model.dto.PromoDto;
import ru.otus.microservice.architecture.promo.model.entity.PromoEntity;

@Component
public class PromoDtoToPromoEntityConverter implements Converter<PromoDto, PromoEntity> {
    @Override
    public PromoEntity convert(PromoDto promoDto) {
        PromoEntity promoEntity = new PromoEntity();
        promoEntity.setId(null);
        promoEntity.setName(promoDto.getName());
        promoEntity.setCode(promoDto.getCode());
        promoEntity.setActive(promoDto.getActive());
        promoEntity.setDiscount(promoDto.getDiscount());
        promoEntity.setFrom(promoDto.getFrom());
        promoEntity.setTo(promoDto.getTo());
        return promoEntity;
    }
}