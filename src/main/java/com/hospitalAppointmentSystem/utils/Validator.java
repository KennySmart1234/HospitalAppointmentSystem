package com.hospitalAppointmentSystem.utils;

import com.hospitalAppointmentSystem.dtos.requests.PatientRegistrationRequest;
import com.hospitalAppointmentSystem.exceptions.HospitalAppException;

import java.util.List;


public class Validator {
    public static void validate(PatientRegistrationRequest request) throws HospitalAppException{
        if (request == null) throw new HospitalAppException("Field cannot be empty");
        validateField(request.getFullname(), "Fullname");
        validateField(request.getEmail(), "email");
        validateField(request.getPhone(), "Phone");
        validateField(request.getPassword(), "password");
        validateField(request.getGender(), "Gender");
        validateField(request.getAddress(), "Address");

        if (request.getDateOfBirth() == null) throw new HospitalAppException("Date cannot be Empty");

    }

    public static void validateField(String value, String fieldName) throws HospitalAppException{
        if (value == null || value.isBlank()) throw new HospitalAppException("Invalid" + fieldName);
    }

    public static void validateField(List<String> value, String fieldName) throws HospitalAppException{
        if (value == null || value.isEmpty()) throw new HospitalAppException("Invalid" + fieldName);

    }

    public static void validateField(int value, String fieldName) throws HospitalAppException{
        if (value <= 0) throw new HospitalAppException("Invalid" + fieldName);
    }


}

