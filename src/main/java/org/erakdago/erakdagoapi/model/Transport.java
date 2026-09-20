package org.erakdago.erakdagoapi.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transport {
    private UUID id;
    private String name;
    private String type;
    private String description;
    private String departureLocation;
    private String arrivalLocation;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private Double cost;
    private String duration;
}
