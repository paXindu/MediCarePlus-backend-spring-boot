package com.medicareplus.MediCarePlus.service;

import com.medicareplus.MediCarePlus.dto.EmployeeDTO;
import com.medicareplus.MediCarePlus.entity.Employee;
import com.medicareplus.MediCarePlus.repo.EmployeeRepo;
import com.medicareplus.MediCarePlus.util.EmployeeRoll;
import com.medicareplus.MediCarePlus.util.VarList;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {


    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ModelMapper modelMapper;



    public String saveEmployee(EmployeeDTO employeeDTO) {

        if (employeeRepo.existsById(employeeDTO.getEmployeeNic())) {
            return VarList.RSP_DUPLICATED;
        } else {
            employeeRepo.save(modelMapper.map(employeeDTO, Employee.class));
            return VarList.RSP_SUCCESS;
            }

    }
    public String updateEmployee(EmployeeDTO employeeDTO){

        if (employeeRepo.existsById(employeeDTO.getEmployeeNic())){
            employeeRepo.save(modelMapper.map(employeeDTO, Employee.class));
            return VarList.RSP_SUCCESS;

        }else {


            return VarList.RSP_NO_DATA_FOUND;

        }
    }


    public List<EmployeeDTO> getAllEmployee() {
        List<Employee> allEmployeeList = employeeRepo.findAll();
        return modelMapper.map(allEmployeeList, new TypeToken<List<EmployeeDTO>>() {}.getType());
    }


    public EmployeeDTO searchEmployee(int employeeId){
        if(employeeRepo.existsById(employeeId)) {
            Employee searchedEmployee = employeeRepo.findById(employeeId).orElse(null);
            return modelMapper.map(searchedEmployee, EmployeeDTO.class);
        }
        else {
            return null;
        }
    }


    public String employeeDelete(int employeeId){
        if(employeeRepo.existsById(employeeId)){
            employeeRepo.deleteById(employeeId);
            return VarList.RSP_SUCCESS;
        }else return VarList.RSP_NO_DATA_FOUND;
    }
}
