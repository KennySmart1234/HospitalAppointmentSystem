package com.hospitalAppointmentSystem.data.repositories;


import com.hospitalAppointmentSystem.data.models.DoctorAvailability;
import org.springframework.data.jpa.repository.JpaRepository;


import java.time.LocalDateTime;
import java.util.List;


public interface DoctorAvailabilityRepository extends JpaRepository<DoctorAvailability, Long> {
    List<DoctorAvailability> findByDoctor(Long doctorId);

    boolean existsByDoctorIdAndAvailabilityDatetime(Long doctorId, LocalDateTime availability);
}
