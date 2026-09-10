package com.hospitalAppointmentSystem.controllers;

import com.hospitalAppointmentSystem.dtos.requests.AdminRegistrationRequest;
import com.hospitalAppointmentSystem.dtos.responses.AdminRegistrationResponse;
import com.hospitalAppointmentSystem.dtos.responses.ApiResponse;
import com.hospitalAppointmentSystem.exceptions.HospitalAppException;
import com.hospitalAppointmentSystem.services.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {
    private AdminService adminService;

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
}
