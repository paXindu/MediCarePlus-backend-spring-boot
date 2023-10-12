package com.medicareplus.MediCarePlus.service;
import com.medicareplus.MediCarePlus.entity.Employee;
import com.medicareplus.MediCarePlus.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {


    @Autowired
    private EmployeeRepo employeeRepo;
    public ResponseEntity<String> saveEmployee(Employee employee) {
        try {
            employeeRepo.save(employee);
            return new ResponseEntity<>("Success",HttpStatus.CREATED);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return new ResponseEntity<>("Bad request",HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> updateEmployee(Employee employee) {
        try {
        if (employeeRepo.existsById(employee.getEmployeeNic())) {
            employeeRepo.save(employee);

        }
            return new ResponseEntity<>("Updated",HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Bad request",HttpStatus.BAD_REQUEST);
    }


    public ResponseEntity <List<Employee>> getAllEmployee() {
        try {
            return new ResponseEntity<>(employeeRepo.findAll(), HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }


    public ResponseEntity<Employee> searchEmployee(int employeeNic) {

        try {
            return new ResponseEntity<>(employeeRepo.findById(employeeNic).orElse(null), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            {
                return new ResponseEntity<>( HttpStatus.NOT_FOUND);
            }
        }
    }



    public ResponseEntity<String> employeeDelete(int employeeNic){
        try {
            employeeRepo.deleteById(employeeNic);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>( HttpStatus.BAD_REQUEST);

    }
}
