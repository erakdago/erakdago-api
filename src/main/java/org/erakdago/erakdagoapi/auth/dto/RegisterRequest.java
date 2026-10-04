package org.erakdago.erakdagoapi.auth.dto;

public record RegisterRequest(
        String firstName,
        String lastName,
        String username,
        String phoneNumber,
        String email,
        String password,
        String pfp,
        String about
) {
}
