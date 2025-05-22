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

    @PostMapping
    public Doctor save(@RequestBody Doctor d) {
        return doctorService.saveDoctor(d);
    }

    @GetMapping
    public List<Doctor> all() {
        return doctorService.getAllDoctors();
    }
}
