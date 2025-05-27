package com.example.clinic_management_system.controller;

import com.example.clinic_management_system.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class DashboardController {
    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/dashboard")
    public Map<String, Object> getDashboard() {
        return dashboardService.getDashboardData();
    }
    @GetMapping("/dashboard/appointments")
    public List<Map<String, Object>> getAppointmentsByDate(@RequestParam String date) {
        return dashboardService.getAppointmentsByDate(date);
    }
}