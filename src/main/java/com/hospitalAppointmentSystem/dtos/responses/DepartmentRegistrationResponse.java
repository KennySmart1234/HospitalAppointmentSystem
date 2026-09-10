package com.hospitalAppointmentSystem.dtos.responses;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class DepartmentRegistrationResponse {

    private Long id;
    private String name;
    private String description;
    private LocalDateTime createdAt;
}
