package com.example.webapp.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Table(name = "usr")
@Data
@Entity(name = "usr")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false,unique = true, length = 45, name = "email")
    private String email;

    @Column(nullable = false, length = 64, name = "password")
    private String password;

    @Column(nullable = false, length = 20, name = "first_name")
    private String firstname;

    @Column(nullable = false, length = 20, name = "last_name")
    private String lastname;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private List<Appointment> appointments;

}