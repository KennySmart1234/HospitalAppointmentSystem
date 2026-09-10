package com.hospitalAppointmentSystem.services;

import com.hospitalAppointmentSystem.data.models.Department;
import com.hospitalAppointmentSystem.data.repositories.DepartmentRepository;
import com.hospitalAppointmentSystem.dtos.requests.DepartmentRegisterRequest;
import com.hospitalAppointmentSystem.dtos.responses.DepartmentRegistrationResponse;
import com.hospitalAppointmentSystem.exceptions.HospitalAppException;
import com.hospitalAppointmentSystem.utils.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;

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
    public List<Department> getAllDepartments(){

        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentByName(String name) throws HospitalAppException{
        return departmentRepository.findByName(name).
                orElseThrow(() -> new HospitalAppException("Department not found"));
    }

    @Override
    public Department getDepartmentById(Long id)
        throws HospitalAppException{
        return departmentRepository.findById(id)
                .orElseThrow(() ->
                        new HospitalAppException("Department not found"));
    }


}
