package org.erakdago.erakdagoapi.auth.dto;

import java.util.UUID;

public record LoginResponse(
        UUID id,
        String username,
        String email,
        String status

        // TODO: add accessToken later
) {
}
