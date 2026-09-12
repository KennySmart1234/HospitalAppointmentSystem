package com.hospitalAppointmentSystem.utils;

import com.hospitalAppointmentSystem.dtos.requests.AdminRegistrationRequest;
import com.hospitalAppointmentSystem.dtos.requests.PatientRegistrationRequest;
import com.hospitalAppointmentSystem.exceptions.HospitalAppException;

import java.util.List;


public class Validator {
    public static void validatePatient(PatientRegistrationRequest request)
            throws HospitalAppException{
        if (request == null) throw new HospitalAppException("Field cannot be empty");
        validatePatientField(request.getFullname(), "Fullname");
        validatePatientField(request.getEmail(), "email");
        validatePatientField(request.getPhone(), "Phone");
        validatePatientField(request.getPassword(), "password");
        validatePatientField(request.getGender(), "Gender");
        validatePatientField(request.getAddress(), "Address");

        if (request.getDateOfBirth() == null)
            throw new HospitalAppException("Date cannot be Empty");

    }

    public static void validatePatientField(String value, String fieldName)
            throws HospitalAppException{
        if (value == null || value.isBlank())
            throw new HospitalAppException("Invalid " + fieldName);
    }
    public static void validatePatientField(List<String> value, String fieldName)
            throws HospitalAppException{
        if (value == null || value.isEmpty())
            throw new HospitalAppException("Invalid " + fieldName);
    }

    public static void validatePatientField(int value, String fieldName)
            throws HospitalAppException{
        if (value <= 0) throw new HospitalAppException("Invalid " + fieldName);
    }



    public static void validateAdmin(AdminRegistrationRequest request)
            throws HospitalAppException {
        if (request == null) throw new HospitalAppException("Field cannot be empty");
        validateAdminField(request.getFullname(), "Fullname");
        validateAdminField(request.getEmail(), "email");
        validateAdminField(request.getPhone(), "Phone");
        validateAdminField(request.getPassword(), "password");
        validateAdminField(request.getGender(), "Gender");
        validateAdminField(request.getAddress(), "Address");
    }

    public static void validateAdminField(String value, String fieldName)
            throws HospitalAppException {

        if (value == null || value.isBlank())
            throw new HospitalAppException("Invalid " + fieldName);
    }

    }

