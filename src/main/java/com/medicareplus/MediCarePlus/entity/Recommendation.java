package com.medicareplus.MediCarePlus.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="Recommendation")
public class Recommendation {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int recommendationId;
        private int appointmentId;


}
