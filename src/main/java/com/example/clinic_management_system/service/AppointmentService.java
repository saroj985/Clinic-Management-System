package com.example.clinic_management_system.service;

import com.example.clinic_management_system.model.Appointment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AppointmentService {
    Appointment scheduleAppointment(Appointment appointment);
    void cancelAppointment(Integer appointment_id);
    Appointment rescheduleAppointment(Integer appointment_id, Appointment newDetails);
    List<Appointment> getAllAppointments();
}
