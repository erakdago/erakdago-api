package org.erakdago.erakdagoapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Follow {
    private UUID id;
    private LocalDateTime createdAt;
    private UUID followerId; // FK -> Traveler.id
    private UUID followingId; // FK -> Traveler.id
}