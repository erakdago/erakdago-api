package org.erakdago.erakdagoapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Destination {
    private UUID id;
    private String name;
    private String description;
    private String image;
    private LocalTime bestTimeToVisit;
    private UUID tripId; // FK -> Trip.id
}
