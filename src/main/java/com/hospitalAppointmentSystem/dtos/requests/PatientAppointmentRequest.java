package com.hospitalAppointmentSystem.dtos.requests;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PatientAppointmentRequest {
    private Long departmentName;
    private LocalDateTime appointmentDateTime;
    private String description;
}
