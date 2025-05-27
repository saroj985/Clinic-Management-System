package com.example.clinic_management_system.repository;

import com.example.clinic_management_system.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
//    List<Appointment> findByDateStartingWith(String date);
List<Appointment> findByDateBetween(Timestamp start, Timestamp end);

}
