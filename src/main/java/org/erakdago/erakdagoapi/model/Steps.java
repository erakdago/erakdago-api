package org.erakdago.erakdagoapi.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Steps {
    private UUID id;
    private String order;
    private Date departureDate;
    private Date arrivalDate;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private String notes;
    private int duration;
    private UUID trip; // FK -> Trip.id
}
