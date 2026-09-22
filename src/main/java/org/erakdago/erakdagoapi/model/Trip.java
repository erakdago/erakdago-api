package org.erakdago.erakdagoapi.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

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
    private List<TripInvitation> tripInvitations;
    private List<TripProposal> tripProposals;
}
