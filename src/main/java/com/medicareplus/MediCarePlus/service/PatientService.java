package com.medicareplus.MediCarePlus.service;
import org.modelmapper.TypeToken;
import com.medicareplus.MediCarePlus.entity.Patient;
import com.medicareplus.MediCarePlus.repo.PatientRepo;
import com.medicareplus.MediCarePlus.util.VarList;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import com.medicareplus.MediCarePlus.dto.PatientDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PatientService  {

    @Autowired
    private PatientRepo patientRepo;

    @Autowired
    private ModelMapper modelMapper;

    public String savePatient(PatientDTO patientDTO){

        if (patientRepo.existsById(patientDTO.getPatientId())){
            return VarList.RSP_DUPLICATED;

        }else {

            patientRepo.save(modelMapper.map(patientDTO, Patient.class));
            return VarList.RSP_SUCCESS;

        }
    }

    public String updatePatient(PatientDTO patientDTO){

        if (patientRepo.existsById(patientDTO.getPatientId())){
            patientRepo.save(modelMapper.map(patientDTO, Patient.class));
            return VarList.RSP_SUCCESS;

        }else {


            return VarList.RSP_NO_DATA_FOUND;

        }
    }


    public List<PatientDTO> getAllPatient() {
        List<Patient> allPatientList = patientRepo.findAll();
        return modelMapper.map(allPatientList, new TypeToken<List<PatientDTO>>() {}.getType());
    }


    public PatientDTO searchPatient(int patientId){
        if(patientRepo.existsById(patientId)) {
            Patient searchedPatient = patientRepo.findById(patientId).orElse(null);
            return modelMapper.map(searchedPatient, PatientDTO.class);
        }
        else {
            return null;
        }
    }


    public String patientDelete(int patientId){
        if(patientRepo.existsById(patientId)){
            patientRepo.deleteById(patientId);
            return VarList.RSP_SUCCESS;
        }else return VarList.RSP_NO_DATA_FOUND;
    }

}



