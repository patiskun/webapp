package com.example.webapp.service;

import com.example.webapp.entity.Appointment;
import com.example.webapp.entity.Doctor;
import com.example.webapp.entity.User;
import com.example.webapp.repository.DoctorRepository;
import com.example.webapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClinicService {
    @PersistenceContext
    private EntityManager entityManager;
    private final DoctorRepository doctorRepository;
    private final UserRepository userRepository;

    @Autowired
    public ClinicService(DoctorRepository doctorRepository, UserRepository userRepository) {
        this.doctorRepository = doctorRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void InsertNewDoctor(Doctor doctor) {
        entityManager.persist(doctor);
        entityManager.flush();
    }

    @Transactional
    public void InsertNewAppointment(Appointment appointment){
        entityManager.persist(appointment);
        entityManager.flush();
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
