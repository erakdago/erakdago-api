package org.erakdago.erakdagoapi.auth.controller;

import lombok.RequiredArgsConstructor;
import org.erakdago.erakdagoapi.auth.dto.AuthResponse;
import org.erakdago.erakdagoapi.auth.dto.LoginRequest;
import org.erakdago.erakdagoapi.auth.dto.RegisterRequest;
import org.erakdago.erakdagoapi.auth.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public AuthResponse register(@RequestBody RegisterRequest registerRequest) {
        return authService.register(registerRequest);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }

}
