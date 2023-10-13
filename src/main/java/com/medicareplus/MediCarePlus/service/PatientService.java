package com.medicareplus.MediCarePlus.service;
import com.medicareplus.MediCarePlus.repository.PatientRepo;
import com.medicareplus.MediCarePlus.entity.Patient;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class PatientService {

    @Autowired
    private PatientRepo patientRepo;

    public ResponseEntity<String> savePatient(Patient patient) {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();


        Set<ConstraintViolation<Patient>> violations = validator.validate(patient);


        if (!violations.isEmpty()) {
            StringBuilder errorMessages = new StringBuilder("Validation errors");
            for (ConstraintViolation<Patient> violation : violations) {
                errorMessages.append(violation.getMessage()).append("\n");
            }
            return new ResponseEntity<>(errorMessages.toString(), HttpStatus.BAD_REQUEST);
        }


        if (patientRepo.existsById(patient.getPatientNic())) {
            return new ResponseEntity<>("This user is registered", HttpStatus.ALREADY_REPORTED);
        } else {
            try {
                patientRepo.save(patient);
                return new ResponseEntity<>("Success", HttpStatus.CREATED);
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<>("Error while saving the patient", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    public ResponseEntity<String> updatePatient(Patient patient) {
        try {
            if (patientRepo.existsById(patient.getPatientNic())) {
                patientRepo.save(patient);
                return new ResponseEntity<>("Updated", HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Bad request", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Patient>> getAllPatient() {
        try {
            return new ResponseEntity<>(patientRepo.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Patient> searchPatient(String patientId) {
        try {
            return new ResponseEntity<>(patientRepo.findById(patientId).orElse(null), HttpStatus.FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<String> patientDelete(String patientId) {
        try {
            patientRepo.deleteById(patientId);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}



