package org.erakdago.erakdagoapi.user.service;

import lombok.RequiredArgsConstructor;
import org.erakdago.erakdagoapi.exception.UserNotFoundException;
import org.erakdago.erakdagoapi.user.dto.CreateUserDTO;
import org.erakdago.erakdagoapi.user.dto.UserResponse;
import org.erakdago.erakdagoapi.user.model.User;
import org.erakdago.erakdagoapi.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserResponse getUserById(UUID id) {
        return userRepository.findUserById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    public List<UserResponse> getUsers() {
        return userRepository.findUsers();
    }

    public UserResponse createUser(CreateUserDTO createUserDTO) {
        User user = userRepository.createUser(createUserDTO);
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
}
