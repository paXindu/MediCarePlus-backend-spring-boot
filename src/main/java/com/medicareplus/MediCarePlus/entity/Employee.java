package com.medicareplus.MediCarePlus.entity;

import com.medicareplus.MediCarePlus.util.EmployeeRoll;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="Employee")



public class Employee {


    @Id
    private int employeeNic;

    private String employeeName;

    @Enumerated(EnumType.STRING)
    private EmployeeRoll employeeRoll;


}
