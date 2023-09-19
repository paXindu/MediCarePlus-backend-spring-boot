package com.medicareplus.MediCarePlus.repo;

import com.medicareplus.MediCarePlus.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepo extends JpaRepository <Employee,Integer> {
}
