package com.hospitalAppointmentSystem.dtos.requests;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PatientAppointmentRequest {
    private String departmentName;
    private LocalDateTime appointmentDateTime;
    private String description;
    //check
}
