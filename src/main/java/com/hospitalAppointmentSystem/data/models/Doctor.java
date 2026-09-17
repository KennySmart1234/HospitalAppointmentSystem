package com.hospitalAppointmentSystem.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Doctor extends User{

    private String specialization;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToMany
    @JoinColumn(name = "doctor_id")
    private List<Appointment> appointments = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "doctor_id")
    private List<DoctorAvailability> availabilities = new ArrayList<>();
}
