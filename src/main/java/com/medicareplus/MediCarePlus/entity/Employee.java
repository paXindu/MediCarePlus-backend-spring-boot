package com.medicareplus.MediCarePlus.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


enum Roll{
    DOCTOR,RECEPTIONIST,PHARMACIST, LABORATORY
}

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="Employee")



public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;

    @Enumerated(EnumType.STRING)
    private Roll employeeRoll;

    private String employeeName;


}
