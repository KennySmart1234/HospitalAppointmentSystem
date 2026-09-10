package com.hospitalAppointmentSystem.dtos.responses;

import com.hospitalAppointmentSystem.data.models.UserRole;
import lombok.Data;

@Data
public class AdminRegistrationResponse {
    private String message;
    private String fullname;
    private String email;
    private UserRole role;


}
