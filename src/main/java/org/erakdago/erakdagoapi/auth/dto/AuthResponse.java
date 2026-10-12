package org.erakdago.erakdagoapi.auth.dto;

import org.erakdago.erakdagoapi.user.dto.UserResponse;

public record AuthResponse(
        String accessToken,
        String tokenType,
        long expiresIn,
        UserResponse user
) {
}
