package org.erakdago.erakdagoapi.user.service;

import lombok.RequiredArgsConstructor;
import org.erakdago.erakdagoapi.exception.UserNotFoundException;
import org.erakdago.erakdagoapi.user.dto.UserResponse;
import org.erakdago.erakdagoapi.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserResponse getUserById(UUID id) {
        return userRepository.findUserById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    public List<UserResponse> getUsers() throws SQLException {
        return userRepository.findUsers();
    }
}
