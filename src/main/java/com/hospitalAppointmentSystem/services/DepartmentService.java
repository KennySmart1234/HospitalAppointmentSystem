package com.hospitalAppointmentSystem.services;

import com.hospitalAppointmentSystem.data.models.Department;
import com.hospitalAppointmentSystem.dtos.requests.DepartmentRegisterRequest;
import com.hospitalAppointmentSystem.dtos.responses.DepartmentRegistrationResponse;
import com.hospitalAppointmentSystem.exceptions.HospitalAppException;

import java.util.List;

public interface DepartmentService {
    DepartmentRegistrationResponse createDepartment(DepartmentRegisterRequest request) throws HospitalAppException;

    List<Department> getAllDepartments();

    Department getDepartmentById(Long id) throws HospitalAppException;

    Department getDepartmentByName(String name) throws HospitalAppException;
}
