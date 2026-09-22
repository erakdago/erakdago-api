package org.erakdago.erakdagoapi.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Favorite {
    private UUID id;
    private LocalDateTime createdAt;
    private FavoriteStatus status;
    private UUID TownId;
    public enum FavoriteStatus {
        SAVED,PLANNED,VISITED
    }
}
