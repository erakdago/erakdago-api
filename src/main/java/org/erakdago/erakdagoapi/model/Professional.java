package org.erakdago.erakdagoapi.model;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

public class Professional extends User{
    private String companyName;
    private String businessType;
    private String description;
    private String businessAddress;
    private String verificationStatus;
    private String licenseNumber;
    private String businessLocation;
    private Set<Activity> activities;
    public Professional(UUID id, String firstName, String lastName, String username, String phoneNumber, String email, String password, String pfp, String about, LocalDateTime registrationDate, String status) {
        super(id, firstName, lastName, username, phoneNumber, email, password, pfp, about, registrationDate, status);
    }
}
