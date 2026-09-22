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
public class Post {
    private UUID id;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String image;
    private UUID authorId; // FK -> Traveler.id
    private List<Comment> comments;
    private List<Like> likes;
}