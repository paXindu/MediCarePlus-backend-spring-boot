package com.medicareplus.MediCarePlus.controller;

import com.medicareplus.MediCarePlus.entity.Patient;
import com.medicareplus.MediCarePlus.service.PatientService;
import com.medicareplus.MediCarePlus.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Patient")
@CrossOrigin
public class PatientController {
    @Autowired
    private PatientService patientService;



    @PostMapping("/savePatient")
    public ResponseEntity<String> savePatient(@RequestBody Patient patient){
        return patientService.savePatient(patient);

    }

    @PutMapping("/updatePatient")
    public String updatePatient(@RequestBody Patient patient){
        return patientService.updatePatient(patient);


    }
    @GetMapping("/getAllPatient")
    public List<Patient> getAllPatient (){

        return patientService.getAllPatient();

    }

    @GetMapping("/searchPatient/{patientId}")
    public Patient searchPatient(@PathVariable int patientId) {

        return patientService.searchPatient(patientId);
    }


    @DeleteMapping("/deletePatient/{patientId}")
    public String patientDelete(@PathVariable int patientId) {

        return patientService.patientDelete(patientId);

    }
}


