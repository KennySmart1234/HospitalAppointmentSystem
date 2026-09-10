package com.hospitalAppointmentSystem.services;

import com.hospitalAppointmentSystem.data.models.User;
import com.hospitalAppointmentSystem.data.repositories.UserRepository;
import com.hospitalAppointmentSystem.dtos.requests.LoginRequest;
import com.hospitalAppointmentSystem.dtos.responses.LoginResponse;
import com.hospitalAppointmentSystem.exceptions.HospitalAppException;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.hospitalAppointmentSystem.utils.Mapper.mapToLoginResponse;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    public LoginResponse login(LoginRequest request) throws HospitalAppException {
        Optional<User> foundUser = userRepository.findByEmail(request.getEmail());

        if (foundUser.isEmpty())
            throw new HospitalAppException("Email or password is not correct");

        User user = foundUser.get();

        if (!user.getPassword().equals(request.getPassword()))
            throw new HospitalAppException("Invalid Credentials");

        user.setLoggedIn(true);
        user = userRepository.save(user);

        return mapToLoginResponse(user);
    }





}
