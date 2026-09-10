package com.hospitalAppointmentSystem.services;

import com.hospitalAppointmentSystem.data.models.Admin;
import com.hospitalAppointmentSystem.data.repositories.AdminRepository;
import com.hospitalAppointmentSystem.dtos.requests.AdminRegistrationRequest;
import com.hospitalAppointmentSystem.dtos.responses.AdminRegistrationResponse;
import com.hospitalAppointmentSystem.exceptions.HospitalAppException;
import com.hospitalAppointmentSystem.utils.Mapper;
import com.hospitalAppointmentSystem.utils.Validator;
import org.springframework.stereotype.Service;


@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public AdminRegistrationResponse registerAdmin(
            AdminRegistrationRequest request) throws HospitalAppException {
        Validator.validateAdmin(request);

        if (adminRepository.existsByEmail(request.getEmail())) {
            throw new HospitalAppException("Email already exist");
        }

        Admin admin = Mapper.mapToAdmin(request);
        admin.setLoggedIn(false);
        admin = adminRepository.save(admin);

        return Mapper.mapToAdminRegistrationResponse(admin);

    }


}
