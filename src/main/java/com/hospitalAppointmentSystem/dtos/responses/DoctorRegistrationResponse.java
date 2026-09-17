package com.hospitalAppointmentSystem.dtos.responses;

import com.hospitalAppointmentSystem.data.models.UserRole;
import lombok.Data;

@Data
public class DoctorRegistrationResponse {
    private String message;
    private String fullName;
    private String email;
    private String specialization;
    private String department;
    private UserRole role;
}
