package com.hospitalAppointmentSystem.services;

import com.hospitalAppointmentSystem.dtos.requests.LoginRequest;
import com.hospitalAppointmentSystem.dtos.requests.LogoutRequest;
import com.hospitalAppointmentSystem.dtos.responses.LoginResponse;
import com.hospitalAppointmentSystem.dtos.responses.LogoutResponse;
import com.hospitalAppointmentSystem.exceptions.HospitalAppException;

public interface AuthService {
    LoginResponse login(LoginRequest request) throws HospitalAppException;
    LogoutResponse logout(LogoutRequest request) throws HospitalAppException;
}
