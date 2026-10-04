package org.erakdago.erakdagoapi.user.service;

import lombok.RequiredArgsConstructor;
import org.erakdago.erakdagoapi.exception.UserNotFoundException;
import org.erakdago.erakdagoapi.user.dto.CreateUserDTO;
import org.erakdago.erakdagoapi.user.dto.UpdatePasswordDTO;
import org.erakdago.erakdagoapi.user.dto.UpdateUserDTO;
import org.erakdago.erakdagoapi.user.dto.UserResponse;
import org.erakdago.erakdagoapi.user.model.User;
import org.erakdago.erakdagoapi.user.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserResponse getUserById(UUID id) {
        return userRepository.findUserById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    public List<UserResponse> getUsers() {
        return userRepository.findUsers();
    }

    public UserResponse createUser(CreateUserDTO createUserDTO) {

        String hashedPassword = passwordEncoder.encode(createUserDTO.password());

        CreateUserDTO userWithHashedPasswordDTO = new CreateUserDTO(
                createUserDTO.firstName(),
                createUserDTO.lastName(),
                createUserDTO.username(),
                createUserDTO.phoneNumber(),
                createUserDTO.email(),
                hashedPassword,
                createUserDTO.pfp(),
                createUserDTO.about()
        );

        User user = userRepository.createUser(userWithHashedPasswordDTO);
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

    public void deleteUser(UUID id) {
        boolean deleted = userRepository.deleteUser(id);
        if (!deleted) {
            throw new UserNotFoundException(id);
        }
    }

    public UserResponse updateUser(UUID id, UpdateUserDTO updateUserDTO) {
        return userRepository.updateUser(id, updateUserDTO);
    }


    //TODO: implement a real invalid password exception that will replace the RuntimeException
    public void updatePassword(UUID id, UpdatePasswordDTO updatePasswordDTO) {
        String currentPasswordHash = userRepository.findPasswordHashById(id).orElseThrow(() -> new UserNotFoundException(id));
        boolean passwordMatches = passwordEncoder.matches(updatePasswordDTO.currentPassword(), currentPasswordHash);

        if (!passwordMatches) {
            throw new RuntimeException("Current password is incorrect");
        }

        String newHashedPassword = passwordEncoder.encode(updatePasswordDTO.newPassword());

        boolean updated = userRepository.updatePassword(id, updatePasswordDTO.newPassword());

        if (!updated) {
            throw new UserNotFoundException(id);
        }
    }
}
