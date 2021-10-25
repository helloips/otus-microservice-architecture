package ru.otus.microservice.architecture.orders.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "tb_requests", indexes = {@Index(columnList = "request_id_")})
@Getter
@Setter
public class RequestEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id_", updatable = false, nullable = false)
    private String id;
    @Column(name = "request_id_")
    private String requestId;
    @Column(name = "order_id_")
    private String orderId;
}