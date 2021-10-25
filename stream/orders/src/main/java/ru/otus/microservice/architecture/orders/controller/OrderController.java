package ru.otus.microservice.architecture.orders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.otus.microservice.architecture.orders.model.domain.Order;
import ru.otus.microservice.architecture.orders.service.OrderService;

import javax.servlet.http.HttpServletResponse;

@RestController
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(path = "account/{id}/order")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void create(@PathVariable(name = "id") String id, @RequestBody Order order, HttpServletResponse httpServletResponse) {
        String orderId = orderService.create(order, id);
        httpServletResponse.setHeader("X-Order-Id", orderId);
    }
}