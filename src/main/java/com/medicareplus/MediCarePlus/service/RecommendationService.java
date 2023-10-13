package com.medicareplus.MediCarePlus.service;

import com.medicareplus.MediCarePlus.dto.RecommendationResponseDTO;
import com.medicareplus.MediCarePlus.entity.Appointment;
import com.medicareplus.MediCarePlus.entity.Employee;
import com.medicareplus.MediCarePlus.entity.Patient;
import com.medicareplus.MediCarePlus.entity.Recommendation;
import com.medicareplus.MediCarePlus.repository.AppointmentRepo;
import com.medicareplus.MediCarePlus.repository.RecommendationRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RecommendationService {

    @Autowired
    private AppointmentRepo appointmentRepo;
    @Autowired
    private RecommendationRepo recommendationRepo;
    @Autowired
    private ModelMapper modelMapper;



    public ResponseEntity <Integer> newRecommendation(int appointmentId ,String recommendationDetails) {
        if (appointmentRepo.existsById(appointmentId))
        {

            Appointment appointment = appointmentRepo.findById(appointmentId).orElse(null);
            Recommendation recommendation = new Recommendation();
            recommendation.setAppointment(appointment);
            recommendation.setRecommendationDetails(recommendationDetails);
            recommendationRepo.save(recommendation);




            return new ResponseEntity<>(recommendation.getRecommendationId(), HttpStatus.CREATED);
        }


        return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity <RecommendationResponseDTO> readRecommendations(int recommendationId) {
        if (recommendationRepo.existsById(recommendationId)){

            Recommendation recommendation= recommendationRepo.findById(recommendationId).orElse(null);

            return new ResponseEntity<>(modelMapper.map(recommendation,RecommendationResponseDTO.class),HttpStatus.OK);
        }
        return new ResponseEntity<>( HttpStatus.NOT_FOUND);
    }
}
