package com.hospitalAppointmentSystem.utils;

import com.hospitalAppointmentSystem.data.models.*;
import com.hospitalAppointmentSystem.dtos.requests.*;
import com.hospitalAppointmentSystem.dtos.responses.*;

import java.time.LocalDateTime;
import java.util.UUID;

public class Mapper {
    public static LoginResponse mapToLoginResponse(User user){
        LoginResponse response = new LoginResponse();
        response.setMessage("Login successful");
        response.setFullname(user.getFullname());
        response.setLoggedIn(user.isLoggedIn());

        return response;
    }

    public static Patient mapToPatient(PatientRegistrationRequest request){
        Patient patient = new Patient();
        patient.setFullname(request.getFullname());
        patient.setEmail(request.getEmail());
        patient.setPhone(request.getPhone());
        patient.setPassword(request.getPassword());
        patient.setDateOfBirth(request.getDateOfBirth());
        patient.setGender(request.getGender());
        patient.setAddress(request.getAddress());

        patient.setRole(UserRole.PATIENT);

        return patient;
    }

    public static PatientRegistrationResponse mapToPatientRegistrationResponse(Patient patient){
        PatientRegistrationResponse response = new PatientRegistrationResponse();
        response.setMessage("Registration Successful ");
        response.setFullname(patient.getFullname());
        response.setEmail(patient.getEmail());
        response.setRole(UserRole.PATIENT);

        return response;
    }

    public static Department mapToDepartment(DepartmentRegisterRequest request) {
        Department department = new Department();
        department.setName(request.getName());
        department.setCreatedAt(LocalDateTime.now());
        department.setDescription(request.getDescription());

        return department;
    }


    public static DepartmentRegistrationResponse mapToDepartmentRegistrationResponse(Department department) {

        DepartmentRegistrationResponse response = new DepartmentRegistrationResponse();
        response.setId(department.getId());
        response.setName(department.getName());
        response.setDescription(department.getDescription());
        response.setCreatedAt(department.getCreatedAt());

        return response;
    }


    public static Admin mapToAdmin(AdminRegistrationRequest request) {

        Admin admin = new Admin();
        admin.setFullname(request.getFullname());
        admin.setEmail(request.getEmail());
        admin.setPhone(request.getPhone());
        admin.setPassword(request.getPassword());
        admin.setDateOfBirth(request.getDateOfBirth());
        admin.setGender(request.getGender());
        admin.setAddress(request.getAddress());
        admin.setRole(UserRole.ADMIN);

        return admin;

    }


    public static AdminRegistrationResponse mapToAdminRegistrationResponse(Admin admin) {
        AdminRegistrationResponse response = new AdminRegistrationResponse();
        response.setMessage("Registration Successful");
        response.setFullname(admin.getFullname());
        response.setEmail(admin.getEmail());
        response.setRole(UserRole.ADMIN);

        return response;
    }

    public static UserResponse mapToUserResponse(User user){
        UserResponse response = new UserResponse();

        response.setId(user.getId());
        response.setFullname(user.getFullname());
        response.setEmail(user.getEmail());
        response.setPhone(user.getPhone());
        response.setRole(user.getRole().name());

        return response;

    }

    public static Appointment mapToAppointment(
            AppointmentRequest.BookAppointmentRequest request,
            UUID patientId,
            String patientName,
            UUID doctorId,
            String doctorName) {

        Appointment appointment = new Appointment();

        appointment.setPatientId(patientId);
        appointment.setPatientName(patientName);
        appointment.setDoctorId(doctorId);
        appointment.setDoctorName(doctorName);

        appointment.setDepartment(request.getDepartment());
        appointment.setDescription(request.getDescription());
        appointment.setAppointmentDatetime(
                request.getAppointmentDatetime()
        );

        appointment.setStatus(AppointmentStatus.PENDING);

        return appointment;
    }


    public static AppointmentResponse.BookAppointmentResponse mapToBookAppointmentResponse(Appointment appointment) {

        AppointmentResponse.BookAppointmentResponse response =
                new AppointmentResponse.BookAppointmentResponse();

        response.setAppointmentId(appointment.getAppointmentId());
        response.setPatientId(appointment.getPatientId());
        response.setPatientName(appointment.getPatientName());
        response.setDoctorId(appointment.getDoctorId());
        response.setDoctorName(appointment.getDoctorName());
        response.setDepartment(appointment.getDepartment());
        response.setDescription(appointment.getDescription());
        response.setAppointmentDatetime(
                appointment.getAppointmentDatetime()
        );
        response.setStatus(appointment.getStatus());

        return response;
    }
}

