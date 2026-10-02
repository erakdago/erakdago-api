package org.erakdago.erakdagoapi.user.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record UserResponse
        (UUID id, String firstName, String lastName, String userName, String phoneNumber,
         LocalDateTime registrationDate, String status) {
}
