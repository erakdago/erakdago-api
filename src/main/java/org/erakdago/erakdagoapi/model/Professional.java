package org.erakdago.erakdagoapi.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class Professional extends User {
    private String companyName;
    private String businessType;
    private String description;
    private String businessAddress;
    private String verificationStatus;
    private String licenseNumber;
    private String businessLocation;
    private Set<Activity> activities;
}
