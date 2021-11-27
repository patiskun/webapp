package com.example.webapp.models;

import com.example.webapp.entity.Doctor;
import com.example.webapp.entity.User;

import java.util.List;

public class AppointmentRequest {
    public List<User> users;
    public List<Doctor> doctors;
}
