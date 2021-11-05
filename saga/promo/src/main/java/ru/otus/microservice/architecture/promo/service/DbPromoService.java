package ru.otus.microservice.architecture.promo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.microservice.architecture.promo.model.dto.PromoDto;
import ru.otus.microservice.architecture.promo.model.entity.PromoEntity;
import ru.otus.microservice.architecture.promo.repository.PromoRepository;

@Service
public class DbPromoService implements PromoService {
    private final PromoRepository promoRepository;
    private final ConversionService conversionService;

    @Autowired
    public DbPromoService(PromoRepository promoRepository, ConversionService conversionService) {
        this.promoRepository = promoRepository;
        this.conversionService = conversionService;
    }

    @Override
    @Transactional
    public PromoDto create(PromoDto promoDto) {
        PromoEntity courseEntity = conversionService.convert(promoDto, PromoEntity.class);
        promoRepository.save(courseEntity);
        return conversionService.convert(courseEntity, PromoDto.class);
    }

    @Override
    @Transactional
    public PromoDto read(String id) {
        PromoEntity promoEntity = promoRepository.findById(id).orElseThrow();
        return conversionService.convert(promoEntity, PromoDto.class);
    }

    @Override
    @Transactional
    public PromoDto update(String id, PromoDto promoDto) {
        PromoEntity promoEntity = promoRepository.findById(id).orElseThrow();
        promoEntity.setName(promoDto.getName());
        promoEntity.setCode(promoDto.getCode());
        promoEntity.setActive(promoDto.getActive());
        promoEntity.setDiscount(promoDto.getDiscount());
        promoEntity.setFrom(promoDto.getFrom());
        promoEntity.setTo(promoDto.getTo());
        return conversionService.convert(promoEntity, PromoDto.class);
    }

    @Override
    @Transactional
    public PromoDto delete(String id) {
        PromoEntity promoEntity = promoRepository.findById(id).orElseThrow();
        PromoDto promoDto = conversionService.convert(promoEntity, PromoDto.class);
        promoRepository.deleteById(id);
        return promoDto;
    }

    @Override
    @Transactional
    public void check(PromoDto promoDto) {
        String code = promoDto.getCode();
        promoRepository.findByCode(code).orElseThrow();
    }
}