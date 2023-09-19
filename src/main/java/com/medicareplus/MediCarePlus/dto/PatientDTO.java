package com.medicareplus.MediCarePlus.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatientDTO {


    private int PatientNic;
    private int PatientPhone;
    private String PatientPassword;
    private String patientName;
    private String patientDOB;
    private String sex;
    private String address;
    private String maritalStatus;
    private String isUnder18;
    private int emergencyContact;
    private String relationship;
}
