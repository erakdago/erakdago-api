package org.erakdago.erakdagoapi.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class Review {
    private UUID id;
    public UUID authorId; // FK -> Traveler.id
    private double rating;
    private String comment;
    private Date createdAt;
    private String status;
    private Date updatedAt;

    private UUID eventId;
    private UUID activityId;
    private UUID townId;
    private UUID serviceID; // only one among the 4
}
