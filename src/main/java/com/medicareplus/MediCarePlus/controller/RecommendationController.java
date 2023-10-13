package com.medicareplus.MediCarePlus.controller;


import com.medicareplus.MediCarePlus.dto.RecommendationResponseDTO;
import com.medicareplus.MediCarePlus.entity.Recommendation;
import com.medicareplus.MediCarePlus.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Recommendation")
@CrossOrigin
public class RecommendationController {


    @Autowired
    private RecommendationService recommendationService;

    @PostMapping("/recommend")
    public ResponseEntity<Integer> newRecommendation(@RequestParam int appointmentId,String recommendationDetails){
        return recommendationService.newRecommendation(appointmentId,recommendationDetails);
    }

    @GetMapping("/read/{recommendationId}")
    public ResponseEntity <RecommendationResponseDTO> readRecommendations(@PathVariable int recommendationId){
        return recommendationService.readRecommendations(recommendationId);
    }

}
