package com.medicareplus.MediCarePlus.repository;

import com.medicareplus.MediCarePlus.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepo extends JpaRepository<Patient ,String> {
}
