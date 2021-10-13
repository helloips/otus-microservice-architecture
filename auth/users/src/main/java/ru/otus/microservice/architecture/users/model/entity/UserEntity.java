package ru.otus.microservice.architecture.users.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tb_users", indexes = {@Index(columnList = "login_")})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue
    @Column(name = "id_")
    private Long id;
    @Column(name = "profile_id_", unique = true)
    private String profileId;
    @Column(name = "login_", unique = true)
    private String login;
    @Column(name = "password_")
    private String password;
}