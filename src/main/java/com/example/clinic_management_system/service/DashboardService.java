package com.example.clinic_management_system.service;

import com.example.clinic_management_system.model.Appointment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public interface DashboardService {
    public Map<String, Object> getDashboardData();

//    List<Appointment> getAppointmentsByDate(String date);
List<Map<String, Object>> getAppointmentsByDate(String date);
}
