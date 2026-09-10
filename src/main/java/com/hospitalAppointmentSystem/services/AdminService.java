package com.hospitalAppointmentSystem.services;

import com.hospitalAppointmentSystem.dtos.requests.AdminRegistrationRequest;
import com.hospitalAppointmentSystem.dtos.responses.AdminRegistrationResponse;
import com.hospitalAppointmentSystem.exceptions.HospitalAppException;

import java.awt.*;

public interface AdminService {
    AdminRegistrationResponse registerAdmin(AdminRegistrationRequest request)
            throws HospitalAppException;
}
