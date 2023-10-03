package com.medicareplus.MediCarePlus.service;

import com.medicareplus.MediCarePlus.dao.AppointmentRepo;
import com.medicareplus.MediCarePlus.dao.EmployeeRepo;
import com.medicareplus.MediCarePlus.dao.PatientRepo;
import com.medicareplus.MediCarePlus.entity.Appointment;
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
            appointment.setPatientNic(patientNic);
            appointment.setEmployeeId(employeeId);
            appointmentRepo.save(appointment);
            return "ok";
        }


        return "Not ok";
    }
}
