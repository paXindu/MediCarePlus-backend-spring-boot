package com.medicareplus.MediCarePlus.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatientDTO {
    private int patientId;
    private String patientName;
    private String patientDOB;
}
