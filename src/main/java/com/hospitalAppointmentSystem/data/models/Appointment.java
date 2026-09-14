package com.hospitalAppointmentSystem.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "appointment")
@Getter
@Setter
@NoArgsConstructor

public class Appointment {

    @Id
    @GeneratedValue
    private UUID appointmentId;

    @Column(nullable = false)
    private UUID patientId;

    @Column(nullable = false)
    private UUID doctorId;

    @Column(nullable = false)
    private String doctorName;

    @Column(nullable = false)
    private String department;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalDateTime appointmentDatetime;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AppointmentStatus status = AppointmentStatus.PENDING;


    public Appointment(UUID patientId, UUID doctorId, String doctorName, String department,
                       String description, LocalDateTime appointmentDatetime) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.department = department;
        this.description = description;
        this.appointmentDatetime = appointmentDatetime;
    }

    public void confirm() {
        this.status = AppointmentStatus.CONFIRMED;
    }

    public void complete() {
        this.status = AppointmentStatus.COMPLETED;
    }

    public void cancel() {
        this.status = AppointmentStatus.CANCELLED;
    }
}


