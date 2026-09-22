package org.erakdago.erakdagoapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckIn {
    private UUID id;
    private LocalDateTime checkedInAt;
    private Double latitude;
    private Double longitude;
    private Integer xpEarned;
    private UUID townId; // FK -> Town.id
    private UUID travelerId; // FK -> Traveler.id
}