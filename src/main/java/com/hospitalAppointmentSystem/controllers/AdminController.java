package com.hospitalAppointmentSystem.controllers;

import com.hospitalAppointmentSystem.dtos.requests.AdminRegistrationRequest;
import com.hospitalAppointmentSystem.dtos.requests.DepartmentRegisterRequest;
import com.hospitalAppointmentSystem.dtos.responses.AdminRegistrationResponse;
import com.hospitalAppointmentSystem.dtos.responses.ApiResponse;
import com.hospitalAppointmentSystem.dtos.responses.DepartmentRegistrationResponse;
import com.hospitalAppointmentSystem.dtos.responses.UserResponse;
import com.hospitalAppointmentSystem.exceptions.HospitalAppException;
import com.hospitalAppointmentSystem.services.AdminService;
import com.hospitalAppointmentSystem.services.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {
    private AdminService adminService;
    private DepartmentService departmentService;

    @PostMapping("/register")
    public ResponseEntity<?> registerAdmin(
            @RequestBody AdminRegistrationRequest request){
        try {
            AdminRegistrationResponse response =
                    adminService.registerAdmin(request);

            return new ResponseEntity<>(
                    new ApiResponse(response, true),
                    HttpStatus.CREATED
            );
        } catch (HospitalAppException ex){
            return new ResponseEntity<>(
                    new ApiResponse(ex.getMessage(), false),
                    BAD_REQUEST
            );
        }


    }



    @PostMapping("Create Department")
    public ResponseEntity<?> createDepartment(
            @RequestBody DepartmentRegisterRequest request){
        try{
            DepartmentRegistrationResponse response =
                    adminService.createDepartment(request);

            return new ResponseEntity<>(
                    new ApiResponse(response, true),
                    HttpStatus.CREATED
            );

        }catch (HospitalAppException ex){
            return new ResponseEntity<>(
                    new ApiResponse(ex.getMessage(), false),
                    BAD_REQUEST
            );
        }
    }




    @GetMapping("/View All users")
    public ResponseEntity<?> viewAllUsers() {

        List<UserResponse> users =
                adminService.viewAllUsers();

        return ResponseEntity.ok(
                new ApiResponse(users, true)
        );
    }

}
