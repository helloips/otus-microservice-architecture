package ru.otus.microservice.architecture.orders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import ru.otus.microservice.architecture.orders.model.domain.Order;
import ru.otus.microservice.architecture.orders.model.entity.OrderEntity;
import ru.otus.microservice.architecture.orders.repository.OrderRepository;

@Service
public class BpmOrderService implements OrderService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final OrderRepository orderRepository;
    private final String orchestratorUri;

    @Autowired
    public BpmOrderService(OrderRepository orderRepository, @Value("${orchestrator.uri}") String orchestratorUri) {
        this.orderRepository = orderRepository;
        this.orchestratorUri = orchestratorUri;
    }

    @Override
    @Transactional
    public String create(Order order, String accountId) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setName(order.getName());
        orderEntity.setPrice(order.getPrice());
        orderEntity.setDescription(order.getDescription());
        orderRepository.save(orderEntity);
        restTemplate.postForEntity(orchestratorUri, null, Void.class, orderEntity.getId(), accountId, order.getPrice());
        return orderEntity.getId();
    }
}