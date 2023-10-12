package com.medicareplus.MediCarePlus.controller;
import com.medicareplus.MediCarePlus.entity.Employee;
import com.medicareplus.MediCarePlus.service.EmployeeService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("Employee")
@CrossOrigin
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;



    @PostMapping("/saveEmployee")
    public ResponseEntity <String> saveEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);

    }

    @PutMapping("/updateEmployee")
    public ResponseEntity<String> updateEmployee(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);


    }
    @GetMapping("/getAllEmployee")
    public ResponseEntity<List<Employee>> getAllEmployee (){

        return employeeService.getAllEmployee();

    }

    @GetMapping("/searchEmployee/{employeeNic}")
    public ResponseEntity<Employee> searchEmployee(@PathVariable int employeeNic) {

        return employeeService.searchEmployee(employeeNic);
    }


    @DeleteMapping("/deleteEmployee/{employeeNic}")
    public ResponseEntity<String> employeeDelete(@PathVariable int employeeNic) {

        return employeeService.employeeDelete(employeeNic);

    }
}
