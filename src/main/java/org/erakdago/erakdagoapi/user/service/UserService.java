package org.erakdago.erakdagoapi.user.service;

import lombok.RequiredArgsConstructor;
import org.erakdago.erakdagoapi.exception.UserNotFoundException;
import org.erakdago.erakdagoapi.user.dto.UserResponse;
import org.erakdago.erakdagoapi.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserResponse getUserById(UUID id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }
}
