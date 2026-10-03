package org.erakdago.erakdagoapi.user.controller;

import lombok.RequiredArgsConstructor;
import org.erakdago.erakdagoapi.user.dto.CreateUserDTO;
import org.erakdago.erakdagoapi.user.dto.UpdateUserDTO;
import org.erakdago.erakdagoapi.user.dto.UserResponse;
import org.erakdago.erakdagoapi.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public UserResponse get(@PathVariable UUID id) {
        return userService.getUserById(id);
    }

    @GetMapping
    public List<UserResponse> getUsers() {
        return userService.getUsers();
    }

    @PostMapping
    public UserResponse create(@RequestBody CreateUserDTO createUserDTO) {
        return userService.createUser(createUserDTO);
    }

    @PatchMapping("/{id}")
    public UserResponse update(@PathVariable UUID id, @RequestBody UpdateUserDTO updateUserDTO) {
        return userService.updateUser(id, updateUserDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        userService.deleteUser(id);
    }
}
