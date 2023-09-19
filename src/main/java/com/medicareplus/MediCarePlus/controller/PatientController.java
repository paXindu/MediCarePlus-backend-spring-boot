package com.medicareplus.MediCarePlus.controller;
import com.medicareplus.MediCarePlus.dto.PatientDTO;
import com.medicareplus.MediCarePlus.dto.RequestDTO;
import com.medicareplus.MediCarePlus.service.PatientService;
import com.medicareplus.MediCarePlus.util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Patient")
@CrossOrigin
public class PatientController {



    @Autowired
    private PatientService patientService;
    @Autowired
    private RequestDTO requestDTO;

    @PostMapping("/savePatient")
    public ResponseEntity savePatient(@RequestBody PatientDTO patientDTO ){
        try{
        String res=patientService.savePatient(patientDTO);

        if (res.equals("00")){
            requestDTO.setCode(VarList.RSP_SUCCESS);
            requestDTO.setMessege("Success");
            requestDTO.setContent(patientDTO);
            return new ResponseEntity(requestDTO, HttpStatus.ACCEPTED);
        }
        else if(res.equals("06")){
            requestDTO.setCode(VarList.RSP_DUPLICATED);
            requestDTO.setMessege("Duplicated");
            requestDTO.setContent(patientDTO);
            return new ResponseEntity(requestDTO, HttpStatus.BAD_REQUEST);
        }
        else {
            requestDTO.setCode(VarList.RSP_FAIL);
            requestDTO.setMessege("Error");
            requestDTO.setContent(null);
            return new ResponseEntity(requestDTO, HttpStatus.BAD_REQUEST);
        }


        }catch (Exception e){
            requestDTO.setCode(VarList.RSP_SUCCESS);
            requestDTO.setMessege(e.getMessage());
            requestDTO.setContent(null);
            return new ResponseEntity(requestDTO, HttpStatus.INTERNAL_SERVER_ERROR);

        }




    }

    @PutMapping ("/updatePatient")
    public ResponseEntity updatePatient(@RequestBody PatientDTO patientDTO ){
        try{
            String res=patientService.updatePatient(patientDTO);

            if (res.equals("00")){
                requestDTO.setCode(VarList.RSP_SUCCESS);
                requestDTO.setMessege("Success");
                requestDTO.setContent(patientDTO);
                return new ResponseEntity(requestDTO, HttpStatus.ACCEPTED);
            }
            else if(res.equals("01")){
                requestDTO.setCode(VarList.RSP_NO_DATA_FOUND);
                requestDTO.setMessege("User Not found");
                requestDTO.setContent(patientDTO);
                return new ResponseEntity(requestDTO, HttpStatus.BAD_REQUEST);
            }
            else {
                requestDTO.setCode(VarList.RSP_FAIL);
                requestDTO.setMessege("Error");
                requestDTO.setContent(null);
                return new ResponseEntity(requestDTO, HttpStatus.BAD_REQUEST);
            }


        }catch (Exception e){
            requestDTO.setCode(VarList.RSP_SUCCESS);
            requestDTO.setMessege(e.getMessage());
            requestDTO.setContent(null);
            return new ResponseEntity(requestDTO, HttpStatus.INTERNAL_SERVER_ERROR);

        }


    }
    @GetMapping("/getAllPatient")
    public ResponseEntity getAllPatient (){
    try{
        List<PatientDTO> patientDTOList= patientService.getAllPatient();
        if (patientDTOList !=null){
            requestDTO.setCode(VarList.RSP_SUCCESS);
            requestDTO.setMessege("Success");
            requestDTO.setContent(patientDTOList);
            return new ResponseEntity(requestDTO, HttpStatus.ACCEPTED);
        }
        else {
            requestDTO.setCode(VarList.RSP_NO_DATA_FOUND);
            requestDTO.setMessege("User Not found");
            requestDTO.setContent(null);
            return new ResponseEntity(requestDTO, HttpStatus.BAD_REQUEST);
        }



    }catch (Exception e){
        requestDTO.setCode(VarList.RSP_SUCCESS);
        requestDTO.setMessege(e.getMessage());
        requestDTO.setContent(null);
        return new ResponseEntity(requestDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    }

    @GetMapping("/searchPatient/{patientId}")
    public ResponseEntity searchPatient(@PathVariable int patientId){


        try{
            PatientDTO searchedPatient=patientService.searchPatient(patientId);
            if (searchedPatient !=null){
                requestDTO.setCode(VarList.RSP_SUCCESS);
                requestDTO.setMessege("Success");
                requestDTO.setContent(searchedPatient);
                return new ResponseEntity(requestDTO, HttpStatus.ACCEPTED);
            }
            else {
                requestDTO.setCode(VarList.RSP_NO_DATA_FOUND);
                requestDTO.setMessege("User Not found");
                requestDTO.setContent(null);
                return new ResponseEntity(requestDTO, HttpStatus.BAD_REQUEST);
            }



        }catch (Exception e){
            requestDTO.setCode(VarList.RSP_SUCCESS);
            requestDTO.setMessege(e.getMessage());
            requestDTO.setContent(null);
            return new ResponseEntity(requestDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/deletePatient/{patientId}")
    public ResponseEntity patientDelete(@PathVariable int patientId){

        try{
            String res=patientService.patientDelete(patientId);
            if (res.equals("00")){
                requestDTO.setCode(VarList.RSP_SUCCESS);
                requestDTO.setMessege("Success");
                requestDTO.setContent(null);
                return new ResponseEntity(requestDTO, HttpStatus.ACCEPTED);
            }
            else {
                requestDTO.setCode(VarList.RSP_NO_DATA_FOUND);
                requestDTO.setMessege("No data found");
                requestDTO.setContent(null);
                return new ResponseEntity(requestDTO, HttpStatus.BAD_REQUEST);
            }

        }catch (Exception e){
            requestDTO.setCode(VarList.RSP_SUCCESS);
            requestDTO.setMessege(e.getMessage());
            requestDTO.setContent(null);
            return new ResponseEntity(requestDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}


