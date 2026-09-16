package org.erakdago.erakdagoapi.model;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor

public class User {
    private UUID id;
    private String firstName;
    private String lastName;
    private String username;
    private String phoneNumber;
    private String email;
    private String password;
    private String pfp;
    private String about;
    private LocalDateTime registrationDate;
    private String status;
}
