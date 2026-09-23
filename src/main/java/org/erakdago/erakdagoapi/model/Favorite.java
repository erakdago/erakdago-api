package org.erakdago.erakdagoapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Favorite {
    private UUID id;
    private LocalDateTime createdAt;
    private FavoriteStatus status;
    private UUID townId; // FK -> Town.id
    private UUID travelerId; // FK -> Traveler.id

    public enum FavoriteStatus {
        SAVED, PLANNED, VISITED
    }
}