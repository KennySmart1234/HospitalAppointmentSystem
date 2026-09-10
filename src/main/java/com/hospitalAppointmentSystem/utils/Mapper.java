package com.hospitalAppointmentSystem.utils;

import com.hospitalAppointmentSystem.data.models.Department;
import com.hospitalAppointmentSystem.data.models.Patient;
import com.hospitalAppointmentSystem.data.models.User;
import com.hospitalAppointmentSystem.data.models.UserRole;
import com.hospitalAppointmentSystem.dtos.requests.DepartmentRegisterRequest;
import com.hospitalAppointmentSystem.dtos.requests.PatientRegistrationRequest;
import com.hospitalAppointmentSystem.dtos.responses.DepartmentRegistrationResponse;
import com.hospitalAppointmentSystem.dtos.responses.LoginResponse;
import com.hospitalAppointmentSystem.dtos.responses.PatientRegistrationResponse;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

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


}
