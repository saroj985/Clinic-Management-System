package com.example.clinic_management_system.controller;

import com.example.clinic_management_system.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.clinic_management_system.service.DoctorService;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

//    @PostMapping("/login")
//    public String login(@RequestParam String username, @RequestParam String password) {
//        boolean authenticated = doctorService.authenticate(username, password);
//        return authenticated ? "Login successful" : "Invalid credentials";
//    }

    @PostMapping("/login")
    public String login(@RequestBody Doctor loginRequest) {
        boolean authenticated = doctorService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());
        return authenticated ? "Login successful" : "Invalid credentials";
    }
    @PostMapping("/register")
    public String register(@RequestBody Doctor doctor) {
        doctorService.saveDoctor(doctor);
        return "Doctor registered successfully";
    }


    @PostMapping
    public Doctor save(@RequestBody Doctor d) {
        return doctorService.saveDoctor(d);
    }

    @GetMapping
    public List<Doctor> all() {
        return doctorService.getAllDoctors();
    }
}
