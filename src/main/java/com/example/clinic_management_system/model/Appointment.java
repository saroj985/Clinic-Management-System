package com.example.clinic_management_system.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
public class Appointment {
    @Id

    @SequenceGenerator(name="appointment_seq", sequenceName = "appointment_seq", allocationSize = 1, initialValue = 100)
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointment_seq")
    @JsonProperty("appointment_id")
    private Integer appointment_id;
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd/HH/mm")
    private Date date;
    private String status;
    private String notes;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public Integer getAppointment_id() {
        return appointment_id;
    }

    public void setAppointment_id(Integer appointment_id) {
        this.appointment_id = appointment_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}