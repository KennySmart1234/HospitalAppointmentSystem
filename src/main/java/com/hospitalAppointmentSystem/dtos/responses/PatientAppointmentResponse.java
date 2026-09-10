package com.hospitalAppointmentSystem.dtos.responses;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PatientAppointmentResponse {
    private Long appointmentId;
    private Long DepartmentName;
    private LocalDateTime appointmentDateTime;
    private String status;
}
