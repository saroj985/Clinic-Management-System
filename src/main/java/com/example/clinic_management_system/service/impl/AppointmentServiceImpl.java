package com.example.clinic_management_system.service.impl;
import com.example.clinic_management_system.model.Appointment;
import com.example.clinic_management_system.model.Doctor;
import com.example.clinic_management_system.model.Patient;
import com.example.clinic_management_system.repository.AppointmentRepository;
import com.example.clinic_management_system.repository.DoctorRepository;
import com.example.clinic_management_system.repository.PatientRepository;
import com.example.clinic_management_system.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Appointment scheduleAppointment(Appointment a) {
        Integer doctorId = a.getDoctor().getDoctor_id();
        Integer patientId = a.getPatient().getPatient_id();

        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new IllegalArgumentException("Doctor does not exist"));
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new IllegalArgumentException("Patient does not exist"));

        a.setDoctor(doctor);
        a.setPatient(patient);

        return appointmentRepository.save(a);
    }

    @Override
    public void cancelAppointment(Integer id) {
        appointmentRepository.deleteById(id);
    }

    @Override
    public Appointment rescheduleAppointment(Integer id, Appointment a) {
        Appointment existing = appointmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Appointment not found"));
        existing.setDate(a.getDate());
        existing.setStatus(a.getStatus());
        existing.setNotes(a.getNotes());
        return appointmentRepository.save(existing);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

}