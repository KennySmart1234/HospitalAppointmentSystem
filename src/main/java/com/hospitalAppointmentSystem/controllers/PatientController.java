package com.hospitalAppointmentSystem.controllers;

import com.hospitalAppointmentSystem.dtos.requests.PatientRegistrationRequest;
import com.hospitalAppointmentSystem.dtos.responses.ApiResponse;
import com.hospitalAppointmentSystem.dtos.responses.PatientRegistrationResponse;
import com.hospitalAppointmentSystem.exceptions.HospitalAppException;
import com.hospitalAppointmentSystem.services.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestController
@RequestMapping("/patients")
@AllArgsConstructor
public class PatientController {

    private final PatientService patientService;


    @PostMapping("/register")
    public ResponseEntity<?> registerPatient(@RequestBody PatientRegistrationRequest request) {
        try{
            PatientRegistrationResponse response = patientService.registerPatient(request);

            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (HospitalAppException ex){

            return new ResponseEntity<>( new ApiResponse(ex.getMessage(), false), BAD_REQUEST);
        }

    }

}
