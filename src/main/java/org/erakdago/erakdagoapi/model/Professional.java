package org.erakdago.erakdagoapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
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
