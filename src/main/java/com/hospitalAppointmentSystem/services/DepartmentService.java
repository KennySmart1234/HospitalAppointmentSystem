package com.hospitalAppointmentSystem.services;

import com.hospitalAppointmentSystem.data.models.Department;
import com.hospitalAppointmentSystem.exceptions.HospitalAppException;

import java.util.List;

public interface DepartmentService {

    List<Department> getAllDepartments();

    Department getDepartmentById(Long id) throws HospitalAppException;

    Department getDepartmentByName(String name) throws HospitalAppException;
}
