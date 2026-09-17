package org.erakdago.erakdagoapi.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString

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
    private UUID townID; // FK -> towns.id
}
