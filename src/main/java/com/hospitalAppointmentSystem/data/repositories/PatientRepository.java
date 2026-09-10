package com.hospitalAppointmentSystem.data.repositories;

import com.hospitalAppointmentSystem.data.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    boolean existsByEmail(String email);

}
