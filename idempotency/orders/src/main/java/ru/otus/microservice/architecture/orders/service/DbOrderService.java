package ru.otus.microservice.architecture.orders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.microservice.architecture.orders.model.domain.Order;
import ru.otus.microservice.architecture.orders.model.entity.OrderEntity;
import ru.otus.microservice.architecture.orders.model.entity.RequestEntity;
import ru.otus.microservice.architecture.orders.repository.OrderRepository;
import ru.otus.microservice.architecture.orders.repository.RequestRepository;

import java.util.Objects;

@Service
public class DbOrderService implements OrderService {
    private final OrderRepository orderRepository;
    private final RequestRepository requestRepository;

    @Autowired
    public DbOrderService(OrderRepository orderRepository, RequestRepository requestRepository) {
        this.orderRepository = orderRepository;
        this.requestRepository = requestRepository;
    }

    @Override
    @Transactional
    public String create(Order order, String requestId) {
        String orderId = requestRepository.findByRequestId(requestId).orElse(new RequestEntity()).getOrderId();
        if (Objects.nonNull(orderId))
            return orderId;
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setName(order.getName());
        orderEntity.setPrice(order.getPrice());
        orderEntity.setDescription(order.getDescription());
        orderRepository.save(orderEntity);
        orderId = orderEntity.getId();
        RequestEntity requestEntity = new RequestEntity();
        requestEntity.setOrderId(orderId);
        requestEntity.setRequestId(requestId);
        requestRepository.save(requestEntity);
        return orderId;
    }
}