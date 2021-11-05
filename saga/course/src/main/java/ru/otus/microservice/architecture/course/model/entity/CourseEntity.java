package ru.otus.microservice.architecture.course.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_courses")
@Getter
@Setter
public class CourseEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id_", updatable = false, nullable = false)
    private String id;
    @Column(name = "name_")
    private String name;
    @Column(name = "cost_")
    private Double cost;
    @Column(name = "limit_")
    private Integer limit;
    @Column(name = "from_")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date from;
    @Column(name = "to_")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date to;
}