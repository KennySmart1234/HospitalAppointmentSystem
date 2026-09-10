package com.hospitalAppointmentSystem.dtos.responses;

import lombok.Data;

@Data
public class PatientRegistrationResponse {
    private String message;
    private String fullname;
    private String email;
}
