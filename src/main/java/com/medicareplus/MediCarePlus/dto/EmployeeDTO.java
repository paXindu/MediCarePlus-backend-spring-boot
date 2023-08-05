package com.medicareplus.MediCarePlus.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDTO {
    private int employeeId;
    private String employeeName;
    private String employeeDOB;

}
