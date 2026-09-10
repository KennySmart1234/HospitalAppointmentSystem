package com.hospitalAppointmentSystem.services;

import com.hospitalAppointmentSystem.dtos.requests.PatientRegistrationRequest;
import com.hospitalAppointmentSystem.dtos.responses.PatientRegistrationResponse;
import com.hospitalAppointmentSystem.exceptions.HospitalAppException;

public interface PatientService {
    PatientRegistrationResponse registerPatient(PatientRegistrationRequest request) throws HospitalAppException;

}
