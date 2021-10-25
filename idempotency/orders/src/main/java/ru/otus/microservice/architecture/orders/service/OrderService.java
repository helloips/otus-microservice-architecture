package ru.otus.microservice.architecture.orders.service;

import ru.otus.microservice.architecture.orders.model.domain.Order;

public interface OrderService {
    String create(Order order, String accountId);
}