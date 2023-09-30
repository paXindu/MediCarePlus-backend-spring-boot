package com.medicareplus.MediCarePlus.service;
import com.medicareplus.MediCarePlus.entity.Employee;
import com.medicareplus.MediCarePlus.dao.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {


    @Autowired
    private EmployeeRepo employeeRepo;
    public String saveEmployee(Employee employee) {

        employeeRepo.save(employee);
        return "SUCCESS";
    }

    public String updateEmployee(Employee employee) {

        if (employeeRepo.existsById(employee.getEmployeeNic())) {
            employeeRepo.save(employee);

        }
        return "SUCCESS";
    }


    public List<Employee> getAllEmployee() {

        return employeeRepo.findAll();
    }


    public Employee searchEmployee(int employeeId) {
        return employeeRepo.findById(employeeId).orElse(null);
    }



    public String employeeDelete(int employeeId){

            employeeRepo.deleteById(employeeId);
            return "SUCCESS";

    }
}
