package com.example.webapp.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table(name = "appointment")
@Entity
@Data
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

    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    @Column(name = "a_date", columnDefinition = "TIMESTAMP")
    private Date utilDate;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "appointment_id")
//    private List<Doctor> doctors;
}