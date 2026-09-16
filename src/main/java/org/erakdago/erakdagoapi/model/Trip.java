package org.erakdago.erakdagoapi.model;

import java.time.LocalDateTime;
import java.util.UUID;

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

}
