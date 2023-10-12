package com.medicareplus.MediCarePlus.entity;

import com.medicareplus.MediCarePlus.util.EmployeeRoll;
import jakarta.persistence.*;


@Entity

@Table(name="Employee")



public class Employee {


    @Id
    private int employeeNic;

    private String employeeName;

    @Enumerated(EnumType.STRING)
    private EmployeeRoll employeeRoll;


    public int getEmployeeNic() {
        return employeeNic;
    }

    public void setEmployeeNic(int employeeNic) {
        this.employeeNic = employeeNic;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public EmployeeRoll getEmployeeRoll() {
        return employeeRoll;
    }

    public void setEmployeeRoll(EmployeeRoll employeeRoll) {
        this.employeeRoll = employeeRoll;
    }
}
