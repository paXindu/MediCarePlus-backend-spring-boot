package com.medicareplus.MediCarePlus.service;
import com.medicareplus.MediCarePlus.dao.PatientRepo;
import com.medicareplus.MediCarePlus.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PatientService {


    @Autowired
    private PatientRepo patientRepo;
    public String savePatient(Patient patient) {

        patientRepo.save(patient);
        return "SUCCESS";
    }

    public String updatePatient(Patient patient) {

        if (patientRepo.existsById(patient.getPatientNic())) {
            patientRepo.save(patient);

        }
        return "SUCCESS";
    }


    public List<Patient> getAllPatient() {

        return patientRepo.findAll();
    }


    public Patient searchPatient(int patientId) {
        return patientRepo.findById(patientId).orElse(null);
    }



    public String patientDelete(int patientId){

        patientRepo.deleteById(patientId);
        return "SUCCESS";

    }
}



