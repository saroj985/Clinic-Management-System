package com.example.clinic_management_system.service.impl;

import com.example.clinic_management_system.model.Appointment;
import com.example.clinic_management_system.model.Doctor;
import com.example.clinic_management_system.model.Patient;
import com.example.clinic_management_system.repository.AppointmentRepository;
import com.example.clinic_management_system.repository.DoctorRepository;
import com.example.clinic_management_system.repository.PatientRepository;
import com.example.clinic_management_system.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DashboardServiceImpl implements DashboardService {
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;
    private DashboardServiceImpl dashboardService;


    @Override
    public Map<String, Object> getDashboardData() {
        Map<String, Object> data = new HashMap<>();
        data.put("appointmentsCount", appointmentRepository.count());
        data.put("doctorsCount", doctorRepository.count());
        data.put("patientsCount", patientRepository.count());
        return data;
    }
    @Override
    public List<Map<String, Object>> getAppointmentsByDate(String date) {
        LocalDate localDate = LocalDate.parse(date);
        LocalDateTime startOfDay = localDate.atStartOfDay();
        LocalDateTime endOfDay = localDate.plusDays(1).atStartOfDay().minusNanos(1);
        Timestamp start = Timestamp.valueOf(startOfDay);
        Timestamp end = Timestamp.valueOf(endOfDay);

        List<Appointment> appointments = appointmentRepository.findByDateBetween(start, end);

        Map<Doctor, List<Patient>> doctorPatients = new HashMap<>();
        for (Appointment appt : appointments) {
            doctorPatients
                    .computeIfAbsent(appt.getDoctor(), k -> new ArrayList<>())
                    .add(appt.getPatient());
        }

        List<Map<String, Object>> result = new ArrayList<>();
        for (Map.Entry<Doctor, List<Patient>> entry : doctorPatients.entrySet()) {
            Map<String, Object> row = new HashMap<>();
            row.put("doctor", entry.getKey().getName());
            row.put("patients", entry.getValue().stream().map(Patient::getName).toList());
            result.add(row);
        }
        return result;
    }


}
