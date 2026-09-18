package org.erakdago.erakdagoapi.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Trip {
    private UUID id;
    private String name;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private boolean status;
    private LocalDateTime createdAt;
    private Traveler traveler;
    private Destination destination;
    private List<Steps> steps;
}
