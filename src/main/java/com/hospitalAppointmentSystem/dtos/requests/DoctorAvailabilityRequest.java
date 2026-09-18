package com.hospitalAppointmentSystem.dtos.requests;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DoctorAvailabilityRequest {
    private LocalDateTime availabilityDateTime;
}