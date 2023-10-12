package com.medicareplus.MediCarePlus.entity;
import jakarta.persistence.*;

import org.springframework.stereotype.Component;


@Entity
@Component
@Table(name="Appointment")

public class Appointment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appointmentId;

    @ManyToOne
    @JoinColumn(name = "patientNic")
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "employeeNic")
    private Employee employee;



    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}

