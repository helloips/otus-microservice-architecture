package ru.otus.microservice.architecture.profiles.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import ru.otus.microservice.architecture.profiles.model.domain.Citizenship;

import javax.persistence.*;

@Entity
@Table(name = "tb_profiles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfileEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id_", updatable = false, nullable = false)
    private String id;
    @Column(name = "full_name_")
    private String fullName;
    @Enumerated(EnumType.STRING)
    @Column(name = "citizenship_")
    private Citizenship citizenship;
    @Column(name = "age_")
    private Integer age;
}