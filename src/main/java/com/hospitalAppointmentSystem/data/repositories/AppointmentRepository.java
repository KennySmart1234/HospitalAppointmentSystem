package com.hospitalAppointmentSystem.data.repositories;

import com.hospitalAppointmentSystem.data.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AppointmentRepository extends JpaRepository<Appointment, UUID> {

    Optional<Appointment> findByDoctorIdAndAppointmentDatetime(UUID doctorId, LocalDateTime appointmentDatetime);
    List<Appointment> findByDoctorId(UUID doctorId);
    List<Appointment> findByPatientId(UUID patientId);
}


