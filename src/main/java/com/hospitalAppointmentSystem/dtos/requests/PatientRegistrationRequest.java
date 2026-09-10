package com.hospitalAppointmentSystem.dtos.requests;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientRegistrationRequest {

    private String fullname;
    private String email;
    private String phone;
    private String password;
    private LocalDate dateOfBirth;
    private String gender;
    private String address;
}
