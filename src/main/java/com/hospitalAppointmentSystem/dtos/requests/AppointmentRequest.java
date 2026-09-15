package com.hospitalAppointmentSystem.dtos.requests;


import com.hospitalAppointmentSystem.data.models.AppointmentStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;



public class AppointmentRequest {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BookAppointmentRequest{

        @NotBlank
        private String department;

        @NotBlank
        private String description;

        @NotNull
        private LocalDateTime appointmentDatetime;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ChangeAppointmentStatusRequest{

        @NotNull
        private AppointmentStatus status;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AdminBookAppointmentRequest{

        @NotNull
        private UUID patientId;

        @NotBlank
        private String department;

        @NotBlank
        private String description;

        @NotNull
        private LocalDateTime appointmentDatetime;
    }
}
