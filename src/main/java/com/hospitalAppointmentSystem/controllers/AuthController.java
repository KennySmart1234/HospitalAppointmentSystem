package com.hospitalAppointmentSystem.controllers;

import com.hospitalAppointmentSystem.dtos.requests.LoginRequest;
import com.hospitalAppointmentSystem.dtos.responses.ApiResponse;
import com.hospitalAppointmentSystem.dtos.responses.LoginResponse;
import com.hospitalAppointmentSystem.exceptions.HospitalAppException;
import com.hospitalAppointmentSystem.services.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request){
        try{
            LoginResponse response = authService.login(request);

            return ResponseEntity.ok(
                    new ApiResponse(response, true));
        }catch (HospitalAppException ex){
            return new ResponseEntity<>(
                    new ApiResponse(ex.getMessage(), false), BAD_REQUEST);
        }
    }
}
