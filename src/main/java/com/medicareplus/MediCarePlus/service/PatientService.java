package com.medicareplus.MediCarePlus.service;
import com.medicareplus.MediCarePlus.repository.PatientRepo;
import com.medicareplus.MediCarePlus.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {


    @Autowired
    private PatientRepo patientRepo;
    public ResponseEntity<String> savePatient(Patient patient) {
        try {
        patientRepo.save(patient);
            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return new ResponseEntity<>("Bad request",HttpStatus.BAD_REQUEST);
    }


    public ResponseEntity<String> updatePatient(Patient patient) {
        try {
        if (patientRepo.existsById(patient.getPatientNic())) {
            patientRepo.save(patient);

        }
            return new ResponseEntity<>("Updated",HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Bad request",HttpStatus.BAD_REQUEST);
    }


    public ResponseEntity <List<Patient>> getAllPatient() {
        try {
            return new ResponseEntity<>( patientRepo.findAll(),HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }


    public ResponseEntity<Patient> searchPatient(int patientId) {
        try {
            return new ResponseEntity<>(patientRepo.findById(patientId).orElse(null),HttpStatus.FOUND);

        }catch (Exception e){
            e.printStackTrace();
            {
                return new ResponseEntity<>( HttpStatus.NOT_FOUND);
            }
        }
    }



    public ResponseEntity<String> patientDelete(int patientId){
        try {
        patientRepo.deleteById(patientId);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>( HttpStatus.BAD_REQUEST);

    }
}



