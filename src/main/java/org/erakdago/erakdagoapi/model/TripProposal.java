package org.erakdago.erakdagoapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TripProposal {
    private UUID id;
    private LocalDateTime createdAt;
    private String title;
    private String description;
    private UUID tripId; // FK -> Trip.id
    private List<Steps> steps;
    private List<Vote> votes;
}