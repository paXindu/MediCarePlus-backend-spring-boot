package com.medicareplus.MediCarePlus.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@Entity
@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="Appointment")

public class Appointment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appointmentNic;

    @ManyToOne
    @JoinColumn(name = "patientNic")
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "employeeNic")
    private Employee employee;


}

