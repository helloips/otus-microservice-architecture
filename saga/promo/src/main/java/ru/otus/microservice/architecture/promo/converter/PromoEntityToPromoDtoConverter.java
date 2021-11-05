package ru.otus.microservice.architecture.promo.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.otus.microservice.architecture.promo.model.dto.PromoDto;
import ru.otus.microservice.architecture.promo.model.entity.PromoEntity;

@Component
public class PromoEntityToPromoDtoConverter implements Converter<PromoEntity, PromoDto> {
    @Override
    public PromoDto convert(PromoEntity promoEntity) {
        PromoDto promoDto = new PromoDto();
        promoDto.setId(promoEntity.getId());
        promoDto.setName(promoEntity.getName());
        promoDto.setCode(promoEntity.getCode());
        promoDto.setActive(promoEntity.getActive());
        promoDto.setDiscount(promoEntity.getDiscount());
        promoDto.setFrom(promoEntity.getFrom());
        promoDto.setTo(promoEntity.getTo());
        return promoDto;
    }
}