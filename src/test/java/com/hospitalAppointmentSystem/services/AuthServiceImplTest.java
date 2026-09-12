package com.hospitalAppointmentSystem.services;

import com.hospitalAppointmentSystem.data.models.User;
import com.hospitalAppointmentSystem.data.repositories.UserRepository;
import com.hospitalAppointmentSystem.dtos.requests.LoginRequest;
import com.hospitalAppointmentSystem.dtos.requests.LogoutRequest;
import com.hospitalAppointmentSystem.dtos.responses.LoginResponse;
import com.hospitalAppointmentSystem.dtos.responses.LogoutResponse;
import com.hospitalAppointmentSystem.exceptions.HospitalAppException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AuthServiceImplTest {

    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private AuthServiceImpl authService;


    @Test
    public void login_withValidEmailAndPassword_logInSuccessful_test() throws HospitalAppException{
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail("kenny@gmail.com");
        loginRequest.setPassword("12345");

        User user = new User();
        user.setEmail("kenny@gmail.com");
        user.setPassword("12345");
        user.setFullname("Kenny Smart");
        user.setLoggedIn(false);

        when(userRepository.findByEmail(loginRequest.getEmail())).thenReturn(Optional.of(user));
        when(userRepository.save(any(User.class))).thenReturn(user);

        LoginResponse response = authService.login(loginRequest);

        assertTrue(response.isLoggedIn());
        assertEquals("Kenny Smart", response.getFullname());

        verify(userRepository).findByEmail(loginRequest.getEmail());
        verify(userRepository).save(any(User.class));
    }


    @Test
    public void login_withUnknownEmail_throwsException_test() throws HospitalAppException {

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail("unknown@gmail.com");
        loginRequest.setPassword("1234");

        when(userRepository.findByEmail(loginRequest.getEmail())).thenReturn(Optional.empty());

        HospitalAppException exception = assertThrows( HospitalAppException.class, () -> authService.login(loginRequest));

        assertEquals("Email or password is not correct", exception.getMessage());

        verify(userRepository).findByEmail(loginRequest.getEmail());
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    public void login_withWrongPassword_throwsException_test() throws HospitalAppException {

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail("kenny@gmail.com");
        loginRequest.setPassword("wrongPassword");

        User user = new User();
        user.setEmail("kenny@gmail.com");
        user.setPassword("1234");
        user.setFullname("Kenny Smart");

        when(userRepository.findByEmail(loginRequest.getEmail())).thenReturn(Optional.of(user));

        HospitalAppException exception = assertThrows(HospitalAppException.class, () -> authService.login(loginRequest));

        assertEquals("Invalid Credentials", exception.getMessage());

        verify(userRepository).findByEmail(loginRequest.getEmail());
        verify(userRepository, never()).save(any(User.class));
    }


    @Test
    public void logout_withValidEmail_logsOutSuccessfully_test() throws HospitalAppException {

        LogoutRequest logoutRequest = new LogoutRequest();
        logoutRequest.setEmail("kenny@gmail.com");

        User user = new User();
        user.setEmail("kenny@gmail.com");
        user.setFullname("Kenny Smart");
        user.setLoggedIn(true);

        when(userRepository.findByEmail(logoutRequest.getEmail())).thenReturn(Optional.of(user));
        when(userRepository.save(any(User.class))).thenReturn(user);

        LogoutResponse response = authService.logout(logoutRequest);

        assertTrue(response.isLoggedOut());
        assertEquals("Logout successful", response.getMessage());

        verify(userRepository).findByEmail(logoutRequest.getEmail());
        verify(userRepository).save(any(User.class));
    }


    @Test
    public void logout_withUnknownEmail_throwsException_test() throws HospitalAppException {

        LogoutRequest logoutRequest = new LogoutRequest();
        logoutRequest.setEmail("unknown@gmail.com");

        when(userRepository.findByEmail(logoutRequest.getEmail())).thenReturn(Optional.empty());

        HospitalAppException exception = assertThrows(HospitalAppException.class, () -> authService.logout(logoutRequest));

        assertEquals("Email does not exist", exception.getMessage());

        verify(userRepository).findByEmail(logoutRequest.getEmail());
        verify(userRepository, never()).save(any(User.class));
    }


    @Test
    public void logout_whenUserAlreadyLoggedOut_throwsException_test() throws HospitalAppException {

        LogoutRequest logoutRequest = new LogoutRequest();
        logoutRequest.setEmail("kenny@gmail.com");

        User user = new User();
        user.setEmail("kenny@gmail.com");
        user.setFullname("Kenny Smart");
        user.setLoggedIn(false);

        when(userRepository.findByEmail(logoutRequest.getEmail())).thenReturn(Optional.of(user));

        HospitalAppException exception = assertThrows(HospitalAppException.class, () -> authService.logout(logoutRequest));

        assertEquals("User is already logged out", exception.getMessage());

        verify(userRepository).findByEmail(logoutRequest.getEmail());
        verify(userRepository, never()).save(any(User.class));
    }



}
