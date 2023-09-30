package com.medicareplus.MediCarePlus.controller;
import com.medicareplus.MediCarePlus.entity.Employee;
import com.medicareplus.MediCarePlus.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("Employee")
@CrossOrigin
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;



    @PostMapping("/saveEmployee")
    public String saveEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);

    }

    @PutMapping("/updateEmployee")
    public String updateEmployee(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);


    }
    @GetMapping("/getAllEmployee")
    public List<Employee> getAllEmployee (){

        return employeeService.getAllEmployee();

    }

    @GetMapping("/searchEmployee/{employeeId}")
    public Employee searchEmployee(@PathVariable int employeeId) {

        return employeeService.searchEmployee(employeeId);
    }


    @DeleteMapping("/deleteEmployee/{employeeId}")
    public String employeeDelete(@PathVariable int employeeId) {

        return employeeService.employeeDelete(employeeId);

    }
}
