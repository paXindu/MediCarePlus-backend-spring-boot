package com.medicareplus.MediCarePlus.dto;

import com.medicareplus.MediCarePlus.entity.Appointment;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class RecommendationResponseDTO{

    private int recommendationId;
    private int appointmentId;

    private String recommendationDetails;

    public int getRecommendationId() {
        return recommendationId;
    }

    public void setRecommendationId(int recommendationId) {
        this.recommendationId = recommendationId;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getRecommendationDetails() {
        return recommendationDetails;
    }

    public void setRecommendationDetails(String recommendationDetails) {
        this.recommendationDetails = recommendationDetails;
    }
}
