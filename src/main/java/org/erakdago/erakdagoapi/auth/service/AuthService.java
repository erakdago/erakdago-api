package org.erakdago.erakdagoapi.auth.service;


import lombok.RequiredArgsConstructor;
import org.erakdago.erakdagoapi.auth.dto.AuthResponse;
import org.erakdago.erakdagoapi.auth.dto.LoginRequest;
import org.erakdago.erakdagoapi.auth.dto.RegisterRequest;
import org.erakdago.erakdagoapi.security.JwtService;
import org.erakdago.erakdagoapi.user.dto.CreateUserDTO;
import org.erakdago.erakdagoapi.user.dto.UserResponse;
import org.erakdago.erakdagoapi.user.model.User;
import org.erakdago.erakdagoapi.user.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor
@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    private AuthResponse createAuthResponse(User user) {
        String token = jwtService.generateToken(user);
        UserResponse userResponse = new UserResponse(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getUsername(),
                user.getPhoneNumber(),
                user.getRegistrationDate(),
                user.getStatus()
        );

        return new AuthResponse(
                token,
                "Bearer",
                jwtService.getExpirationSeconds(),
                userResponse
        );
    }

    public AuthResponse register(RegisterRequest registerRequest) {
        String hashedPassword = passwordEncoder.encode(registerRequest.password());

        CreateUserDTO createUserDTO = new CreateUserDTO(
                registerRequest.firstName(),
                registerRequest.lastName(),
                registerRequest.username(),
                registerRequest.phoneNumber(),
                registerRequest.email(),
                registerRequest.password(),
                registerRequest.pfp(),
                registerRequest.about()
        );

        User user = userRepository.createUser(createUserDTO);

        return createAuthResponse(user);
    }

    private ResponseStatusException invalidCredentials() {
        return new ResponseStatusException(
                HttpStatus.UNAUTHORIZED, "Invalid email or password"
        );
    }

    public AuthResponse login(LoginRequest loginRequest) {
        User user = userRepository.findUsersByEmail(loginRequest.email()).orElseThrow(() -> invalidCredentials());

        if (!passwordEncoder.matches(loginRequest.password(), user.getPassword())) {
            throw invalidCredentials();
        }

        if (!"ACTIVE".equalsIgnoreCase(user.getStatus())) {
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN, "This account is inactive"
            );
        }

        return createAuthResponse(user);
    }

}
