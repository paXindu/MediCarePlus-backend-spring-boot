package com.medicareplus.MediCarePlus.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="Patient")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Patient {
    @Id
    @Pattern(regexp = "\\d{11}V", message = "Enter a valid NIC (11 characters ending with 'V').")
    private String patientNic;

    @Pattern(regexp = "0\\d{9}", message = "Enter a valid phone number (10 digits starting with '0').")
    private String patientPhone;

    @NotNull(message = "Password is required.")
    private String patientPassword;

    @Pattern(regexp = "^[a-zA-Z]+$", message = "Name must contain only English letters.")
    private String patientName;

    @Pattern(regexp = "^\\d{2}-\\d{2}-\\d{4}$", message = "Enter a valid date format (dd-MM-yyyy).")
    private String patientDOB;

    @Pattern(regexp = "^(Male|Female|Other)$", message = "Gender must be 'Male', 'Female', or 'Other'.")
    private String sex;

    private String address;

    @Pattern(regexp = "^(Married|Single|Widow)$", message = "Marital status must be 'Married', 'Single', or 'Widow'.")
    private String maritalStatus;

    @Pattern(regexp = "^(true|false)$", message = "Enter 'true' or 'false' for isUnder18.")
    private String isUnder18;

    @Pattern(regexp = "0\\d{9}", message = "Enter a valid emergency contact number (10 digits starting with '0').")
    private String emergencyContact;

    @Pattern(regexp = "^[a-zA-Z]+$", message = "Relationship must contain only English letters.")
    private String relationship;


}
