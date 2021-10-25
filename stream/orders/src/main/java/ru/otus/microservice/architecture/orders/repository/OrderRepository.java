package ru.otus.microservice.architecture.orders.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.otus.microservice.architecture.orders.model.entity.OrderEntity;

@Repository
public interface OrderRepository extends CrudRepository<OrderEntity, String> {
}