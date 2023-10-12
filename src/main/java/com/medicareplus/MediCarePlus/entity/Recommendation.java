package com.medicareplus.MediCarePlus.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="Recommendation")


public class Recommendation {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int recommendationId;
        @OneToOne
        @JoinColumn(name="appointmentId")
        private Appointment appointment;

        private String recommendationDetails;


        public int getRecommendationId() {
                return recommendationId;
        }

        public void setRecommendationId(int recommendationId) {
                this.recommendationId = recommendationId;
        }

        public Appointment getAppointment() {
                return appointment;
        }

        public void setAppointment(Appointment appointment) {
                this.appointment = appointment;
        }

        public String getRecommendationDetails() {
                return recommendationDetails;
        }

        public void setRecommendationDetails(String recommendationDetails) {
                this.recommendationDetails = recommendationDetails;
        }
}
