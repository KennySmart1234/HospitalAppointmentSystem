package com.hospitalAppointmentSystem.dtos.requests;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AdminRegistrationRequest {
    private String fullname;
    private String password;
    private String phone;
    private String email;
    private String gender;
    private LocalDate dateOfBirth;
    private String address;


}
