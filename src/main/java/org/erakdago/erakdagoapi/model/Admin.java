package org.erakdago.erakdagoapi.model;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

public class Admin extends User{
    private String accessLevel;
    private Set<String> permissions;

    public Admin(UUID id, String firstName, String lastName, String username, String phoneNumber, String email, String password, String pfp, String about, LocalDateTime registrationDate, String status) {
        super(id, firstName, lastName, username, phoneNumber, email, password, pfp, about, registrationDate, status);
    }
}
