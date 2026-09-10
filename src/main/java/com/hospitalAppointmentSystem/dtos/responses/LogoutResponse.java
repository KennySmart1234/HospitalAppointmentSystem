package com.hospitalAppointmentSystem.dtos.responses;

import lombok.Data;

@Data
public class LogoutResponse {
    private String message;
    private boolean loggedOut;
}
