package com.example.clinic_management_system.controller;

import com.example.clinic_management_system.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.clinic_management_system.service.PatientService;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @PostMapping
    public Patient save(@RequestBody Patient p) {
        return patientService.savePatient(p);
    }

    @GetMapping
    public List<Patient> all() {
        return patientService.getAllPatients();
    }
}
