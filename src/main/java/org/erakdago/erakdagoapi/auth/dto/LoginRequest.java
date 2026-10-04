package org.erakdago.erakdagoapi.auth.dto;

public record LoginRequest(
        String email,
        String password
) {
}
