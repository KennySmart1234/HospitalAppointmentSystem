package com.hospitalAppointmentSystem.data.repositories;

import com.hospitalAppointmentSystem.data.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AppointmentRepository extends JpaRepository<Appointment, UUID> {


}
