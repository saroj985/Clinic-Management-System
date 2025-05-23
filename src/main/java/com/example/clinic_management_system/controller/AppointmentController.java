package com.example.clinic_management_system.controller;

import com.example.clinic_management_system.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.clinic_management_system.service.AppointmentService;

import java.util.List;


@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/schedule")
    public Appointment schedule(@RequestBody Appointment a) {
        return appointmentService.scheduleAppointment(a);
    }

    @DeleteMapping("/cancel/{id}")
    public String cancel(@PathVariable Integer id) {
        appointmentService.cancelAppointment(id);
        return "Appointment with ID " + id + " has been cancelled.";
    }

    @PutMapping("/reschedule/{id}")
    public Appointment reschedule(@PathVariable Integer id, @RequestBody Appointment a) {
        return appointmentService.rescheduleAppointment(id, a);
    }

    @GetMapping
    public List<Appointment> all() {
        return appointmentService.getAllAppointments();
    }
}
