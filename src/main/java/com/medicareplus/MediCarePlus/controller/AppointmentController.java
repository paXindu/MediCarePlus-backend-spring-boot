package com.medicareplus.MediCarePlus.controller;


import com.medicareplus.MediCarePlus.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Appointment")
@CrossOrigin
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @PostMapping("/newAppointment")
    public String newAppointment(@RequestParam("employeeNic") int employeeNic, @RequestParam("patientNic") int patientNic) {
        return appointmentService.newAppointment(employeeNic, patientNic);
    }
}
