package com.hospitalAppointmentSystem.controllers;

import com.hospitalAppointmentSystem.data.models.Department;
import com.hospitalAppointmentSystem.dtos.requests.DepartmentRegisterRequest;
import com.hospitalAppointmentSystem.dtos.responses.ApiResponse;
import com.hospitalAppointmentSystem.dtos.responses.DepartmentRegistrationResponse;
import com.hospitalAppointmentSystem.exceptions.HospitalAppException;
import com.hospitalAppointmentSystem.services.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestController
@RequestMapping("/department")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;


    @GetMapping("View all Department")
    public ResponseEntity<?> getAllDepartments() {

        List<Department> departments =
                departmentService.getAllDepartments();

        return ResponseEntity.ok(
                new ApiResponse(departments, true)
        );
    }


    @GetMapping("/Get Department by name")
    public ResponseEntity<?> getDepartmentByName(
            @RequestParam String name) {

        try {
            Department department =
                    departmentService.getDepartmentByName(name);

            return ResponseEntity.ok(
                    new ApiResponse(department, true)
            );

        } catch (HospitalAppException ex) {

            return new ResponseEntity<>(
                    new ApiResponse(ex.getMessage(), false),
                    BAD_REQUEST
            );
        }
    }




}
