package com.example.webapp.entity;

import lombok.Data;

import javax.persistence.*;

@Table(name = "usr")
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false,unique = true, length = 45, name = "email")
    private String email;

    @Column(nullable = false, length = 64, name = "password")
    private String password;

    @Column(nullable = false, length = 20, name = "firstName")
    private String firstname;

    @Column(nullable = false, length = 20, name = "lastName")
    private String lastname;
}