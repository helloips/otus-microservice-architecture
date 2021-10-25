package ru.otus.microservice.architecture.orders.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.otus.microservice.architecture.orders.model.entity.RequestEntity;

import java.util.Optional;

@Repository
public interface RequestRepository extends CrudRepository<RequestEntity, String> {
    Optional<RequestEntity> findByRequestId(String requestId);
}