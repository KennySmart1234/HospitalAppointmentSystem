package com.hospitalAppointmentSystem.services;

import com.hospitalAppointmentSystem.data.models.Appointment;
import com.hospitalAppointmentSystem.data.models.AppointmentStatus;
import com.hospitalAppointmentSystem.dtos.requests.AppointmentRequest;

import java.util.List;
import java.util.UUID;

public interface AppointmentService {

    Appointment createAppointment(UUID patientId, AppointmentRequest.BookAppointmentRequest request);

    List<Appointment> getPatientAppointments(UUID patientId);

    List<Appointment> getDoctorAppointments(UUID doctorId);

    List<Appointment> getAllAppointments();

    Appointment changeStatus(UUID appointmentId, UUID doctorId, AppointmentStatus newStatus);

    Appointment cancelAppointment(UUID appointmentId, UUID patientId);
}
