package com.medicareplus.MediCarePlus.service;

import com.medicareplus.MediCarePlus.repository.AppointmentRepo;
import com.medicareplus.MediCarePlus.repository.EmployeeRepo;
import com.medicareplus.MediCarePlus.repository.PatientRepo;
import com.medicareplus.MediCarePlus.entity.Appointment;
import com.medicareplus.MediCarePlus.entity.Employee;
import com.medicareplus.MediCarePlus.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
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


    public ResponseEntity<Integer> newAppointment(int employeeId, int patientNic){

        if (employeeRepo.existsById(employeeId) && patientRepo.existsById(patientNic))
        {

            Patient patient = patientRepo.findById(patientNic).orElse(null);
            Employee employee = employeeRepo.findById(employeeId).orElse(null);

            appointment.setPatient(patient);
            appointment.setEmployee(employee);
            appointmentRepo.save(appointment);
            return new ResponseEntity<> (appointment.getAppointmentId(),HttpStatus.CREATED);
        }


        return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
    }
}

