package com.hospitalAppointmentSystem.dtos.responses;

import lombok.Data;

@Data
public class LoginResponse {
    private String message;
    private String fullname;
    private boolean isLoggedIn;
}
