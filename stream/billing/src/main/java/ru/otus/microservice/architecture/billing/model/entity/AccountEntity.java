package ru.otus.microservice.architecture.billing.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "tb_accounts")
@Getter
@Setter
public class AccountEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id_", updatable = false, nullable = false)
    private String id;
    @Column(name = "full_name_")
    private String fullName;
    @Column(name = "money_")
    private Double money;
    @Column(name = "email_")
    private String email;
}