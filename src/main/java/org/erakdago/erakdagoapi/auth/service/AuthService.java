package org.erakdago.erakdagoapi.auth.service;


import lombok.RequiredArgsConstructor;
import org.erakdago.erakdagoapi.auth.dto.LoginRequest;
import org.erakdago.erakdagoapi.auth.dto.LoginResponse;
import org.erakdago.erakdagoapi.auth.dto.RegisterRequest;
import org.erakdago.erakdagoapi.exception.DatabaseException;
import org.erakdago.erakdagoapi.exception.UserNotFoundException;
import org.erakdago.erakdagoapi.user.dto.CreateUserDTO;
import org.erakdago.erakdagoapi.user.dto.UserResponse;
import org.erakdago.erakdagoapi.user.model.User;
import org.erakdago.erakdagoapi.user.repository.UserRepository;
import org.erakdago.erakdagoapi.user.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthService {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserResponse register(RegisterRequest registerRequest) {
        String hashedPassword = passwordEncoder.encode(registerRequest.password());

        User user = userRepository.createUser(
                new CreateUserDTO(
                        registerRequest.firstName(),
                        registerRequest.lastName(),
                        registerRequest.username(),
                        registerRequest.phoneNumber(),
                        registerRequest.email(),
                        hashedPassword,
                        registerRequest.pfp(),
                        registerRequest.about()
                )
        );

        return new UserResponse(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getUsername(),
                user.getPhoneNumber(),
                user.getRegistrationDate(),
                user.getStatus()
        );
    }

    public LoginResponse login(LoginRequest loginRequest) {
        User user = userRepository.findUsersByEmail(loginRequest.email()).orElseThrow(() -> new UserNotFoundException("Could not find user with email: " + loginRequest.email()));

        boolean passwordMatches = passwordEncoder.matches(loginRequest.password(), user.getPassword());

        if (!passwordMatches) {
            throw new DatabaseException("Incorrect password");
        }

        return new LoginResponse(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getStatus()
        );
    }

}
