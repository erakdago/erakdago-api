package org.erakdago.erakdagoapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TripInvitation {
    private UUID id;
    private LocalDateTime createdAt;
    private InvitationStatus invitationStatus;
    private LocalDateTime respondedAt;
    private UUID tripId; // FK -> Trip.id
    private UUID travelerId; // FK -> Traveler.id

    public enum InvitationStatus {
        PENDING, ACCEPTED, DECLINED
    }
}