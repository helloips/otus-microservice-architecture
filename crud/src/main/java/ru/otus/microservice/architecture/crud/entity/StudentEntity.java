package ru.otus.microservice.architecture.crud.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_students")
public class StudentEntity {
    @Id
    @GeneratedValue
    @Column(name = "id_")
    private Long id;
    @Column(name = "name_", length = 100)
    private String name;
    @Column(name = "surname_", length = 100)
    private String surname;
    @Column(name = "age_")
    private Integer age;
}
