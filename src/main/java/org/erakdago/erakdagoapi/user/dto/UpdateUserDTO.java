package org.erakdago.erakdagoapi.user.dto;

public record UpdateUserDTO(String firstName, String lastName, String username, String phoneNumber, String email,
                            String pfp, String about) {
}
