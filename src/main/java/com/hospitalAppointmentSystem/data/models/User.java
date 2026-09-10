package com.hospitalAppointmentSystem.data.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;


@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullname;
    private String email;
    private String phone;
    private String password;
    private boolean loggedIn;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    private LocalDate dateOfBirth;
    private String gender;
    private String address;

}
