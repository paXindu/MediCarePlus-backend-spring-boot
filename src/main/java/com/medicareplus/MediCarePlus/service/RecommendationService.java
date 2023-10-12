package com.medicareplus.MediCarePlus.service;

import com.medicareplus.MediCarePlus.entity.Appointment;
import com.medicareplus.MediCarePlus.entity.Employee;
import com.medicareplus.MediCarePlus.entity.Patient;
import com.medicareplus.MediCarePlus.entity.Recommendation;
import com.medicareplus.MediCarePlus.repository.AppointmentRepo;
import com.medicareplus.MediCarePlus.repository.RecommendationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RecommendationService {

    @Autowired
    private AppointmentRepo appointmentRepo;

    @Autowired
    private Appointment appointment;
    @Autowired
    private Recommendation recommendation;

    @Autowired
    private RecommendationRepo recommendationRepo;

    public ResponseEntity <Integer> newRecommendation(int appointmentId ,String recommendationDetails) {
        if (appointmentRepo.existsById(appointmentId))
        {

            appointment = appointmentRepo.findById(appointmentId).orElse(null);
            recommendation.setAppointment(appointment);
            recommendation.setRecommendationDetails(recommendationDetails);
            recommendationRepo.save(recommendation);




            return new ResponseEntity<>(recommendation.getRecommendationId(), HttpStatus.CREATED);
        }


        return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity <Recommendation> readRecommendations(int recommendationId) {
        if (recommendationRepo.existsById(recommendationId)){

            recommendation= recommendationRepo.findById(recommendationId).orElse(null);
            return new ResponseEntity<>(recommendation,HttpStatus.OK);
        }
        return new ResponseEntity<>( HttpStatus.NOT_FOUND);
    }
}
