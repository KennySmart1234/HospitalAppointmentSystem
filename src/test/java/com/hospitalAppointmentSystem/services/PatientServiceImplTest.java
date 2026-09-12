
package com.hospitalAppointmentSystem.services;

import com.hospitalAppointmentSystem.data.models.Patient;
import com.hospitalAppointmentSystem.data.repositories.PatientRepository;
import com.hospitalAppointmentSystem.dtos.requests.PatientRegistrationRequest;
import com.hospitalAppointmentSystem.dtos.responses.PatientRegistrationResponse;
import com.hospitalAppointmentSystem.exceptions.HospitalAppException;

import com.hospitalAppointmentSystem.utils.Validator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PatientServiceImplTest {

    @Mock
    private PatientRepository patientRepository;

    @InjectMocks
    private PatientServiceImpl patientService;

    @Test
    public void registerPatient_withValidDetails_registersSuccessfully_test() throws HospitalAppException {

        PatientRegistrationRequest request = new PatientRegistrationRequest();

        request.setFullname("Kenny Smart");
        request.setEmail("kenny@gmail.com");
        request.setPhone("123456789");
        request.setPassword("Kenny1234");
        request.setGender("Male");
        request.setAddress("Lagos");
        request.setDateOfBirth(LocalDate.of(2007, 5, 10));

        when(patientRepository.existsByEmail(request.getEmail())).thenReturn(false);

        Patient patient = new Patient();
        patient.setFullname("Kenny Smart");
        patient.setEmail("kenny@gmail.com");
        patient.setPhone("123456789");
        patient.setLoggedIn(false);


        when(patientRepository.save(any(Patient.class))).thenReturn(patient);

        PatientRegistrationResponse response = patientService.registerPatient(request);
        assertNotNull(response);

        verify(patientRepository).existsByEmail(request.getEmail());
        verify(patientRepository).save(any(Patient.class));
    }

    @Test
    public void registerPatient_withExistingEmail_throwsException_test() throws HospitalAppException {

        PatientRegistrationRequest request = new PatientRegistrationRequest();

        request.setFullname("Kenny Smart");
        request.setEmail("kenny@gmail.com");
        request.setPhone("123456789");
        request.setPassword("Kenny1234");
        request.setGender("Male");
        request.setAddress("Lagos");
        request.setDateOfBirth(LocalDate.of(2007, 5, 10));

        when(patientRepository.existsByEmail(request.getEmail())).thenReturn(true);

        HospitalAppException exception = assertThrows(HospitalAppException.class,
                () -> patientService.registerPatient(request));
        assertEquals("Email already exist", exception.getMessage());

        verify(patientRepository).existsByEmail(request.getEmail());
        verify(patientRepository, never()).save(any(Patient.class));
    }



    @Test
    public void registerPatient_withNullRequest_throwsException_test() throws HospitalAppException {

        HospitalAppException exception = assertThrows(HospitalAppException.class,
                () -> patientService.registerPatient(null));

        assertEquals("Field cannot be empty", exception.getMessage());

        verify(patientRepository, never()).existsByEmail(anyString());
        verify(patientRepository, never()).save(any(Patient.class));
    }



    @Test
    public void registerPatient_withEmptyFullname_throwsException_test() throws HospitalAppException {

        PatientRegistrationRequest request = new PatientRegistrationRequest();

        request.setFullname("");
        request.setEmail("kenny@gmail.com");
        request.setPhone("123456789");
        request.setPassword("Kenny1234");
        request.setGender("Male");
        request.setAddress("Lagos");
        request.setDateOfBirth(LocalDate.of(2010, 5, 10));

        HospitalAppException exception = assertThrows(HospitalAppException.class,
                () -> patientService.registerPatient(request));

        assertEquals("Invalid Fullname", exception.getMessage());

        verify(patientRepository, never()).existsByEmail(anyString());
        verify(patientRepository, never()).save(any(Patient.class));
    }




    @Test
    public void registerPatient_withEmptyEmail_throwsException_test() throws HospitalAppException {

        PatientRegistrationRequest request = new PatientRegistrationRequest();

        request.setFullname("Kenny Smart");
        request.setEmail("");
        request.setPhone("123456789");
        request.setPassword("Kenny1234");
        request.setGender("Male");
        request.setAddress("Lagos");
        request.setDateOfBirth(LocalDate.of(2007, 5, 10));

        HospitalAppException exception = assertThrows(HospitalAppException.class,
                () -> patientService.registerPatient(request));

        assertEquals("Invalid email", exception.getMessage());

        verify(patientRepository, never()).existsByEmail(anyString());
        verify(patientRepository, never()).save(any(Patient.class));
    }


    @Test
    public void registerPatient_withEmptyPhone_throwsException_test() throws HospitalAppException {

        PatientRegistrationRequest request = new PatientRegistrationRequest();
        request.setFullname("Kenny Smart");
        request.setEmail("kenny@gmail.com");
        request.setPhone("");
        request.setPassword("Kenny1234");
        request.setGender("Male");
        request.setAddress("Lagos");
        request.setDateOfBirth(LocalDate.of(2007, 5, 10));

        HospitalAppException exception = assertThrows(HospitalAppException.class,
                () -> patientService.registerPatient(request));
        assertEquals("Invalid Phone", exception.getMessage());

        verify(patientRepository, never()).existsByEmail(anyString());
        verify(patientRepository, never()).save(any(Patient.class));
    }


    @Test
    public void registerPatient_withEmptyPassword_throwsException_test() throws HospitalAppException {

        PatientRegistrationRequest request = new PatientRegistrationRequest();
        request.setFullname("Kenny Smart");
        request.setEmail("kenny@gmail.com");
        request.setPhone("123456789");
        request.setPassword("");
        request.setGender("Male");
        request.setAddress("Lagos");
        request.setDateOfBirth(LocalDate.of(2007, 5, 10));

        HospitalAppException exception = assertThrows(HospitalAppException.class,
                () -> patientService.registerPatient(request));

        assertEquals("Invalid password", exception.getMessage());

        verify(patientRepository, never()).existsByEmail(anyString());
        verify(patientRepository, never()).save(any(Patient.class));

    }


    @Test
    public void registerPatient_withEmptyGender_throwsException_test() throws HospitalAppException {

        PatientRegistrationRequest request = new PatientRegistrationRequest();
        request.setFullname("Kenny Smart");
        request.setEmail("kenny@gmail.com");
        request.setPhone("123456789");
        request.setPassword("Kenny1234");
        request.setGender("");
        request.setAddress("Lagos");
        request.setDateOfBirth(LocalDate.of(2007, 5, 10));

        HospitalAppException exception = assertThrows(HospitalAppException.class,
                () -> patientService.registerPatient(request));

        assertEquals("Invalid Gender", exception.getMessage());

        verify(patientRepository, never()).existsByEmail(anyString());
        verify(patientRepository, never()).save(any(Patient.class));
    }


    @Test
    public void registerPatient_withEmptyAddress_throwsException_test() throws HospitalAppException {

        PatientRegistrationRequest request = new PatientRegistrationRequest();
        request.setFullname("Kenny Smart");
        request.setEmail("kenny@gmail.com");
        request.setPhone("123456789");
        request.setPassword("Kenny1234");
        request.setGender("Male");
        request.setAddress("");
        request.setDateOfBirth(LocalDate.of(2007, 5, 10));

        HospitalAppException exception = assertThrows(HospitalAppException.class,
                () -> patientService.registerPatient(request));

        assertEquals("Invalid Address", exception.getMessage());

        verify(patientRepository, never()).existsByEmail(anyString());
        verify(patientRepository, never()).save(any(Patient.class));
    }


    @Test
    public void registerPatient_withEmptyDateOfBirth_throwsException_test() throws HospitalAppException {

        PatientRegistrationRequest request = new PatientRegistrationRequest();
        request.setFullname("Kenny Smart");
        request.setEmail("kenny@gmail.com");
        request.setPhone("123456789");
        request.setPassword("Kenny1234");
        request.setGender("Male");
        request.setAddress("Lagos");
        request.setDateOfBirth(null);

        HospitalAppException exception = assertThrows(HospitalAppException.class,
                () -> patientService.registerPatient(request));

        assertEquals("Date cannot be Empty", exception.getMessage());

        verify(patientRepository, never()).existsByEmail(anyString());
        verify(patientRepository, never()).save(any(Patient.class));
    }


    @Test
    public void validatePatientField_withZeroInt_throwsException_test() {

        HospitalAppException exception = assertThrows(HospitalAppException.class,
                () -> Validator.validatePatientField(0, "Age"));
        assertEquals("Invalid Age", exception.getMessage());
    }


    @Test
    public void validatePatientField_withNegativeInt_throwsException_test() {
        HospitalAppException exception = assertThrows(HospitalAppException.class,
                () -> Validator.validatePatientField(-5, "Age"));

        assertEquals("Invalid Age", exception.getMessage()
        );
    }



}




