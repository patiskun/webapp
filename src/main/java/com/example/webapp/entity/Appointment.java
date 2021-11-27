package com.example.webapp.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Table(name = "appointment")
@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user_id;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor_id;

    @Column(name = "a_date")
    private Date utilDate;
//private final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
}