package org.erakdago.erakdagoapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vote {
    private UUID id;
    private LocalDateTime createdAt;
    private UUID tripProposalId; // FK -> TripProposal.id
    private UUID travelerId; // FK -> Traveler.id
}