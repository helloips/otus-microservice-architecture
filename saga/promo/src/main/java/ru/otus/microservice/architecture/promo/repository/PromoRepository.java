package ru.otus.microservice.architecture.promo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.otus.microservice.architecture.promo.model.entity.PromoEntity;

import java.util.Optional;

@Repository
public interface PromoRepository extends CrudRepository<PromoEntity, String> {
    Optional<PromoEntity> findByCode(String code);
}