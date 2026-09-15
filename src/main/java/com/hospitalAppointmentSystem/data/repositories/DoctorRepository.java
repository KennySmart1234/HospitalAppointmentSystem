package com.hospitalAppointmentSystem.data.repositories;

import com.hospitalAppointmentSystem.data.models.Doctor;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public interface DoctorRepository {
    List<Doctor> findBySpecialtyOrDepartment(@NotBlank String department);
}
