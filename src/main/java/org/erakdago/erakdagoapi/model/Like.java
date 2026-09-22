package org.erakdago.erakdagoapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Like {
    private UUID id;
    private LocalDateTime createdAt;
    private UUID postId; // FK -> Post.id
    private UUID travelerId; // FK -> Traveler.id
}