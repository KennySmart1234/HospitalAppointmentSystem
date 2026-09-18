package com.hospitalAppointmentSystem.services;

import com.hospitalAppointmentSystem.data.models.Appointment;
import com.hospitalAppointmentSystem.data.models.AppointmentStatus;
import com.hospitalAppointmentSystem.data.models.Doctor;
import com.hospitalAppointmentSystem.dtos.requests.DoctorRegistrationRequest;
import com.hospitalAppointmentSystem.dtos.responses.DoctorRegistrationResponse;
import com.hospitalAppointmentSystem.exceptions.HospitalAppException;

import java.time.LocalDateTime;
import java.util.List;

public interface DoctorService {
    DoctorRegistrationResponse registerDoctor(DoctorRegistrationRequest request) throws HospitalAppException;


//    Doctor getDoctorById(Long doctorId)
//            throws HospitalAppException;
//
//    List<Appointment> viewAppointments(Long doctorId)
//        throws HospitalAppException;
//
//    AppointmentStatus changeAppointmentStatus(Long doctorId, Long appointmentId, AppointmentStatus status)
//            throws HospitalAppException;
//
//    boolean checkDoctorAvailability(Long doctorId, LocalDateTime availableDateTime)
//        throws HospitalAppException;
//}
