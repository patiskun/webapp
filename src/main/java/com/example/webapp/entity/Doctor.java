package com.example.webapp.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Table(name = "doctor")
@Data
@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20, name = "first_name")
    private String firstname;

    @Column(nullable = false, length = 20, name = "last_name")
    private String lastname;

    @Column(nullable = false, length = 20, name = "type")
    private String type;

    @Column(nullable = false, name = "cabinet")
    private int cabinet;

    @OneToMany
    @JoinColumn(name = "doctor_id")
    private List<Appointment>appointments;
}