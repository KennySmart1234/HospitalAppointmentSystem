package com.hospitalAppointmentSystem.services;

import com.hospitalAppointmentSystem.data.models.Admin;
import com.hospitalAppointmentSystem.data.models.Department;
import com.hospitalAppointmentSystem.data.models.User;
import com.hospitalAppointmentSystem.data.repositories.AdminRepository;
import com.hospitalAppointmentSystem.data.repositories.DepartmentRepository;
import com.hospitalAppointmentSystem.data.repositories.UserRepository;
import com.hospitalAppointmentSystem.dtos.requests.AdminRegistrationRequest;
import com.hospitalAppointmentSystem.dtos.requests.DepartmentRegisterRequest;
import com.hospitalAppointmentSystem.dtos.responses.AdminRegistrationResponse;
import com.hospitalAppointmentSystem.dtos.responses.DepartmentRegistrationResponse;
import com.hospitalAppointmentSystem.dtos.responses.UserResponse;
import com.hospitalAppointmentSystem.exceptions.HospitalAppException;
import com.hospitalAppointmentSystem.utils.Mapper;
import com.hospitalAppointmentSystem.utils.Validator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;
    private final UserRepository userRepository;
    private final DepartmentRepository departmentRepository;

    public AdminServiceImpl(AdminRepository adminRepository,
                            UserRepository userRepository,
                            DepartmentRepository departmentRepository) {
        this.adminRepository = adminRepository;
        this.userRepository = userRepository;
        this.departmentRepository = departmentRepository;
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


    @Override
    public DepartmentRegistrationResponse createDepartment(DepartmentRegisterRequest request)
            throws HospitalAppException {

        if (request == null){
            throw new HospitalAppException("Department cannot be null");
        }

        if(request.getName() == null ||
                request.getName().isBlank()){
            throw new HospitalAppException("Department name is required");
        }

        if (departmentRepository.existsByName(request.getName())){
            throw new HospitalAppException("Department Already exists");
        }

        Department department = Mapper.mapToDepartment(request);
        department = departmentRepository.save(department);
        return Mapper.mapToDepartmentRegistrationResponse(department);
    }



    @Override
    public List<UserResponse> viewAllUsers() {
        List<User> users = userRepository.findAll();

        List<UserResponse> responses = new ArrayList<>();
        for (User user : users){
            UserResponse response = Mapper.mapToUserResponse(user);
            responses.add(response);
        }

        return responses;
    }
}
