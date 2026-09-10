package com.hospitalAppointmentSystem.services;

import com.hospitalAppointmentSystem.dtos.requests.AdminRegistrationRequest;
import com.hospitalAppointmentSystem.dtos.requests.DepartmentRegisterRequest;
import com.hospitalAppointmentSystem.dtos.responses.AdminRegistrationResponse;
import com.hospitalAppointmentSystem.dtos.responses.DepartmentRegistrationResponse;
import com.hospitalAppointmentSystem.dtos.responses.UserResponse;
import com.hospitalAppointmentSystem.exceptions.HospitalAppException;

import java.util.List;


public interface AdminService {
    AdminRegistrationResponse registerAdmin(AdminRegistrationRequest request)
            throws HospitalAppException;

    DepartmentRegistrationResponse createDepartment(DepartmentRegisterRequest request)
            throws HospitalAppException;


    List<UserResponse> viewAllUsers();
}
