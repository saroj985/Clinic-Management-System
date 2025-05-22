package com.example.clinic_management_system.service;

import com.example.clinic_management_system.model.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PatientService {
    Patient savePatient(Patient patient);
    List<Patient> getAllPatients();
}
