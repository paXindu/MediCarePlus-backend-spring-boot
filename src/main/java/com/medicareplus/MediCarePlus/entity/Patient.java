package com.medicareplus.MediCarePlus.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="Patient")

public class Patient {
    @Id
    @OneToMany(mappedBy = "patientNic")
    private int patientNic;
    private int patientPhone;
    private String patientPassword;
    private String patientName;
    private String patientDOB;
    private String sex;
    private String address;
    private String maritalStatus;
    private String isUnder18;
    private int emergencyContact;
    private String relationship;

}
