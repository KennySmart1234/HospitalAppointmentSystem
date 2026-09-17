package com.hospitalAppointmentSystem.services;

import com.hospitalAppointmentSystem.data.models.Department;
import com.hospitalAppointmentSystem.data.repositories.DoctorRepository;
import com.hospitalAppointmentSystem.dtos.requests.DoctorRegistrationRequest;
import com.hospitalAppointmentSystem.dtos.responses.DoctorRegistrationResponse;
import com.hospitalAppointmentSystem.exceptions.HospitalAppException;
import com.hospitalAppointmentSystem.utils.Validator;

public class DoctorServiceImpl implements DoctorService {
    private DoctorRepository doctorRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public DoctorRegistrationResponse registerDoctor(DoctorRegistrationRequest request) throws HospitalAppException {
        Validator.validateDoctor(request);

        if(doctorRepository.existsByEmail(request.getEmail())) {
            throw new HospitalAppException("Doctor already exists");
        }

        return null;

    }
}
