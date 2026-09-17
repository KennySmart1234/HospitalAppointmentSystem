package com.hospitalAppointmentSystem.dtos.requests;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DoctorRegistrationRequest {
    private String fullName;
    private String email;
    private String phone;
    private String password;
    private String specialization;
    private Long departmentId;
    private LocalDate dateOfBirth;
    private String gender;
    private String address;

}
