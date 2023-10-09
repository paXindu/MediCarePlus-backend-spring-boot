package com.medicareplus.MediCarePlus.service;

import com.medicareplus.MediCarePlus.dao.AppointmentRepo;
import com.medicareplus.MediCarePlus.dao.EmployeeRepo;
import com.medicareplus.MediCarePlus.dao.PatientRepo;
import com.medicareplus.MediCarePlus.entity.Appointment;
import com.medicareplus.MediCarePlus.entity.Employee;
import com.medicareplus.MediCarePlus.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {
       @Autowired
       private Appointment appointment;
       @Autowired
       private EmployeeRepo employeeRepo;
       @Autowired
       private PatientRepo patientRepo;
       @Autowired
       private AppointmentRepo appointmentRepo;


    public String newAppointment(int employeeId, int patientNic){

        if (employeeRepo.existsById(employeeId) && patientRepo.existsById(patientNic))
        {

            Patient patient = patientRepo.findById(patientNic).orElse(null);
            Employee employee = employeeRepo.findById(employeeId).orElse(null);

            appointment.setPatient(patient);
            appointment.setEmployee(employee);
            appointmentRepo.save(appointment);
            return "ok";
        }


        return "Not ok";
    }
}
