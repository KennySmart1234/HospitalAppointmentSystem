package com.hospitalAppointmentSystem.dtos.responses;

import com.hospitalAppointmentSystem.data.models.AppointmentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AppointmentResponse {

    private UUID appointmentId;

    private UUID patientId;

    private String patientName;

    private UUID doctorId;

    private String doctorName;

    private String department;

    private String description;

    private LocalDateTime appointmentDatetime;

    private AppointmentStatus status;

}
