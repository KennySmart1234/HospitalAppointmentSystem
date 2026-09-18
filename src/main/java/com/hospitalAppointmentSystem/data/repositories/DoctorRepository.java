package com.hospitalAppointmentSystem.data.repositories;

import com.hospitalAppointmentSystem.data.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    boolean existsByEmail(String email);
}
