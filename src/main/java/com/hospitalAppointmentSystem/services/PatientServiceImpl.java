package com.hospitalAppointmentSystem.services;

import com.hospitalAppointmentSystem.data.models.Patient;
import com.hospitalAppointmentSystem.data.repositories.PatientRepository;
import com.hospitalAppointmentSystem.dtos.requests.PatientRegistrationRequest;
import com.hospitalAppointmentSystem.dtos.responses.PatientRegistrationResponse;
import com.hospitalAppointmentSystem.exceptions.HospitalAppException;
import com.hospitalAppointmentSystem.utils.Mapper;
import com.hospitalAppointmentSystem.utils.Validator;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository){

        this.patientRepository = patientRepository;
    }

    @Override
    public PatientRegistrationResponse registerPatient(PatientRegistrationRequest request) throws HospitalAppException {
        Validator.validatePatient(request);

        if (patientRepository.existsByEmail(request.getEmail())) {
            throw new HospitalAppException("Email already exist");
        }

        Patient patient = Mapper.mapToPatient(request);
        patient.setLoggedIn(false);
        patient = patientRepository.save(patient);

        return Mapper.mapToPatientRegistrationResponse(patient);
    }

}