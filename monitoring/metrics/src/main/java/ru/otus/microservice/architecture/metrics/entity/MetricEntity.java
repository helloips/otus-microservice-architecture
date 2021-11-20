package ru.otus.microservice.architecture.metrics.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tb_metrics")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MetricEntity {
    @Id
    @GeneratedValue
    @Column(name = "id_")
    private Long id;
    @Column(name = "name_")
    private String name;
    @Column(name = "value_")
    private String value;
}