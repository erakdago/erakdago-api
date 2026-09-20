package org.erakdago.erakdagoapi.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    private UUID id;
    private String name;
    private String description;
    private String image;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private boolean status;
    private String location;
    private List<Activity> activities;
    private UUID townId; // FK -> Town.id
    private List<Review> reviewsHistory;
}
