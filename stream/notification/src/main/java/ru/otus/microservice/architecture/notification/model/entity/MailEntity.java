package ru.otus.microservice.architecture.notification.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "tb_mails", indexes = {@Index(columnList = "account_id_"), @Index(columnList = "order_id_")})
@Getter
@Setter
public class MailEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id_", updatable = false, nullable = false)
    private String id;
    @Column(name = "account_id_")
    private String accountId;
    @Column(name = "order_id_")
    private String orderId;
    @Column(name = "email_")
    private String email;
    @Column(name = "text_")
    private String text;
}