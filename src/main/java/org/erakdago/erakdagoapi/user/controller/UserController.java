package org.erakdago.erakdagoapi.user.controller;

import lombok.RequiredArgsConstructor;
import org.erakdago.erakdagoapi.user.dto.UserResponse;
import org.erakdago.erakdagoapi.user.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users/")
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public UserResponse get(@PathVariable UUID id) {
        return userService.getUserById(id);
    }
}
