package com.medicareplus.MediCarePlus.repo;

import com.medicareplus.MediCarePlus.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PatientRepo extends JpaRepository<Patient ,Integer> {
}
