package org.erakdago.erakdagoapi.model;

import lombok.*;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    private UUID id;
    private UUID authorId; // FK -> Traveler.id
    private double rating;
    private String comment;
    private Date createdAt;
    private String status;
    private Date updatedAt;

    private UUID eventId;
    private UUID activityId;
    private UUID townId;
    private UUID serviceId; // only one among the 4
}
