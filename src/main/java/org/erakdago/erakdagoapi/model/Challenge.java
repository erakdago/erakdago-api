package org.erakdago.erakdagoapi.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class Challenge {
    private UUID id;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private double difficulty;
    private double proogress;
    private boolean status;
    private Achievement achievement;
    private UUID regionId; // FK -> Region.id
}
