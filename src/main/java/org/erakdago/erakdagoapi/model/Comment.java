package org.erakdago.erakdagoapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private UUID id;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private UUID authorId; // FK -> Traveler.id
    private UUID postId; // FK -> Post.id
}