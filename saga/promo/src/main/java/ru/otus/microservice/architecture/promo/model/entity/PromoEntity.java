package ru.otus.microservice.architecture.promo.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_promos", indexes = {@Index(columnList = "code_")})
@Getter
@Setter
public class PromoEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id_", updatable = false, nullable = false)
    private String id;
    @Column(name = "name_")
    private String name;
    @Column(name = "code_")
    private String code;
    @Column(name = "active_")
    private Boolean active;
    @Column(name = "discount_")
    private Integer discount;
    @Column(name = "from_")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date from;
    @Column(name = "to_")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date to;
}