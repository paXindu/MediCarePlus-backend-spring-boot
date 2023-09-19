package com.medicareplus.MediCarePlus.controller;

import com.medicareplus.MediCarePlus.dto.EmployeeDTO;
import com.medicareplus.MediCarePlus.dto.RequestDTO;
import com.medicareplus.MediCarePlus.service.EmployeeService;
import com.medicareplus.MediCarePlus.util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("Employee")
@CrossOrigin
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private RequestDTO requestDTO;


    @PostMapping("/saveEmployee")
    public ResponseEntity saveEmployee(@RequestBody EmployeeDTO employeeDTO ){
        try{
            String res=employeeService.saveEmployee(employeeDTO);

            if (res.equals("00")){
                requestDTO.setCode(VarList.RSP_SUCCESS);
                requestDTO.setMessege("Success");
                requestDTO.setContent(employeeDTO);
                return new ResponseEntity(requestDTO, HttpStatus.ACCEPTED);
            }
            else if(res.equals("06")){
                requestDTO.setCode(VarList.RSP_DUPLICATED);
                requestDTO.setMessege("Duplicated");
                requestDTO.setContent(employeeDTO);
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

    @PutMapping("/updateEmployee")
    public ResponseEntity updateEmployee(@RequestBody EmployeeDTO employeeDTO ){
        try{
            String res=employeeService.updateEmployee(employeeDTO);

            if (res.equals("00")){
                requestDTO.setCode(VarList.RSP_SUCCESS);
                requestDTO.setMessege("Success");
                requestDTO.setContent(employeeDTO);
                return new ResponseEntity(requestDTO, HttpStatus.ACCEPTED);
            }
            else if(res.equals("01")){
                requestDTO.setCode(VarList.RSP_NO_DATA_FOUND);
                requestDTO.setMessege("User Not found");
                requestDTO.setContent(employeeDTO);
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
    @GetMapping("/getAllEmployee")
    public ResponseEntity getAllEmployee (){
        try{
            List<EmployeeDTO> employeeDTOList= employeeService.getAllEmployee();
            if (employeeDTOList !=null){
                requestDTO.setCode(VarList.RSP_SUCCESS);
                requestDTO.setMessege("Success");
                requestDTO.setContent(employeeDTOList);
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

    @GetMapping("/searchEmployee/{employeeId}")
    public ResponseEntity searchEmployee(@PathVariable int employeeId){


        try{
            EmployeeDTO searchedEmployee=employeeService.searchEmployee(employeeId);
            if (searchedEmployee !=null){
                requestDTO.setCode(VarList.RSP_SUCCESS);
                requestDTO.setMessege("Success");
                requestDTO.setContent(searchedEmployee);
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


    @DeleteMapping("/deleteEmployee/{employeeId}")
    public ResponseEntity employeeDelete(@PathVariable int employeeId){

        try{
            String res=employeeService.employeeDelete(employeeId);
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
