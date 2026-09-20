package org.erakdago.erakdagoapi.model;

import lombok.*;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Challenge {
    private UUID id;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private double difficulty;
    private double progress;
    private boolean status;
    private Achievement achievement;
    private UUID regionId; // FK -> Region.id
}
