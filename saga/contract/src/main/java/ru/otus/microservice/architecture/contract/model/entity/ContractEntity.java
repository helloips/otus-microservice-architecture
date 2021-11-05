package ru.otus.microservice.architecture.contract.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "tb_contracts")
@Getter
@Setter
public class ContractEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id_", updatable = false, nullable = false)
    private String id;
    @Column(name = "course_id_")
    private String courseId;
    @Column(name = "promo_id_")
    private String promoId;
    @Column(name = "template_")
    private String template;
    @Column(name = "status_")
    private String status;
}