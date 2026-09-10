package com.hospitalAppointmentSystem.services;

import com.hospitalAppointmentSystem.data.models.Department;
import com.hospitalAppointmentSystem.dtos.requests.PatientRegistrationRequest;
import com.hospitalAppointmentSystem.dtos.responses.PatientRegistrationResponse;
import com.hospitalAppointmentSystem.exceptions.HospitalAppException;

public interface PatientService {
    PatientRegistrationResponse registerPatient(PatientRegistrationRequest request) throws HospitalAppException;

//    Object bookAppointment(Long patientId, Department departmentName, Object appointment);
}
