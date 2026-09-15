package com.hospitalAppointmentSystem.services;

import com.hospitalAppointmentSystem.data.models.*;
import com.hospitalAppointmentSystem.data.repositories.*;
import com.hospitalAppointmentSystem.dtos.requests.AppointmentRequest;
import com.hospitalAppointmentSystem.utils.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final UserRepository userRepository;

    public AppointmentServiceImpl(
            AppointmentRepository appointmentRepository,
            DoctorRepository doctorRepository,
            UserRepository userRepository) {

        this.appointmentRepository = appointmentRepository;
        this.doctorRepository = doctorRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Appointment createAppointment(UUID patientId, AppointmentRequest.BookAppointmentRequest request) {

        List<Doctor> doctors = doctorRepository.findBySpecialtyOrDepartment(request.getDepartment());


        for (Doctor doctor : doctors) {

            Optional<Appointment> existing = appointmentRepository.findByDoctorIdAndAppointmentDatetime(
                    doctor.getUserId(), request.getAppointmentDatetime());

            if (existing.isEmpty()) {
                User patient = (User) userRepository.findById(patientId)
                        .orElseThrow(() -> new IllegalStateException("Patient's user record is missing")
                        );

                User doctorUser = userRepository.findById(doctor.getUserId())
                        .orElseThrow(() -> new IllegalStateException("Doctor's user record is missing")
                        );

                Appointment appointment = Mapper.mapToAppointment(
                        request,
                        patientId,
                        patient.getFullname(),
                        doctor.getUserId(),
                        doctorUser.getFullname()
                );

                return appointmentRepository.save(appointment);
            }
        }

        throw new IllegalArgumentException("No doctor is available at this time");
    }

    @Override
    public List<Appointment> getPatientAppointments(UUID patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }

    @Override
    public List<Appointment> getDoctorAppointments(UUID doctorId) {
        return appointmentRepository.findByDoctorId(doctorId);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment changeStatus(UUID appointmentId, UUID doctorId, AppointmentStatus newStatus) {

        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new IllegalArgumentException("No appointment with id " + appointmentId)
                );

        if (!appointment.getDoctorId().equals(doctorId)) {
            throw new IllegalArgumentException("This appointment does not belong to you");
        }


        switch (newStatus) {

            case CONFIRMED -> appointment.confirm();

            case COMPLETED -> appointment.complete();

            case CANCELLED -> appointment.cancel();

            default -> throw new IllegalArgumentException("Cannot change status to " + newStatus);
        }

        return appointmentRepository.save(appointment);
    }


    @Override
    public Appointment cancelAppointment(UUID appointmentId, UUID patientId) {

        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new IllegalArgumentException("No appointment with id " + appointmentId)
                );

        if (patientId != null && !appointment.getPatientId().equals(patientId)) {
            throw new IllegalArgumentException("You can't cancel an appointment with id " + appointmentId);
        }

        appointment.cancel();

        return appointmentRepository.save(appointment);
    }
}
