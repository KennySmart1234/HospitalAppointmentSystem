package com.hospitalAppointmentSystem.dtos.responses;

import lombok.Data;

@Data
public class UserResponse {
    private Long id;
    private String fullname;
    private String email;
    private String phone;
    private String role;
}
