package org.erakdago.erakdagoapi.user.dto;

public record CreateUserDTO(String firstName, String lastName, String username, String phoneNumber, String email,
                            String password, String pfp, String about) {
}
