package com.example.webapp.controller;

import com.example.webapp.entity.Appointment;
import com.example.webapp.entity.Doctor;
import com.example.webapp.entity.User;
import com.example.webapp.models.AppointmentRequest;
import com.example.webapp.repository.UserRepository;
import com.example.webapp.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.print.Doc;
import java.util.List;

@Controller
public class AppController {
    private final UserRepository userRepository;
    private final ClinicService clinicService;

    @Autowired
    public AppController(UserRepository userRepository, ClinicService clinicService) {
        this.userRepository = userRepository;
        this.clinicService = clinicService;
    }

    @GetMapping("")
    public String viewHomePage(){
        return "index";
    }

    @GetMapping("/register")
    public String showSignUpForm(Model model){
        model.addAttribute("user",new User());
        return "signup-form";
    }

    @PostMapping("/process_register")
    public String processRegistration(User user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
        return "index";
    }

    @GetMapping("/list_users")
    public String viewUsersList(Model model){
        List<User> listUsers = userRepository.findAll();
        model.addAttribute("listUsers",listUsers);
        return "users";
    }

    @GetMapping("/add-doctor")
    public String viewAddDoctor(Model model){
        model.addAttribute("doctor" ,new Doctor());
        return "add-doctor";
    }

    @PostMapping("/add-doctor")
    public String addNewDoctor(Doctor doctor){
        clinicService.InsertNewDoctor(doctor);
        return "redirect:list_users";
    }

    @GetMapping("/add-appointment")
    public String viewAddAppointment(Model model){
        var request = new AppointmentRequest();
        request.doctors = clinicService.getAllDoctors();
        request.users = clinicService.getAllUsers();
        model.addAttribute("appointment", new Appointment());
        model.addAttribute("request", request);
        return "add-appointment";
    }

    @PostMapping("/add-appointment")
    public String addNewAppointment(Appointment appointment){
        clinicService.InsertNewAppointment(appointment);
        return "redirect:list_users";
    }

}
