package org.erakdago.erakdagoapi.social.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.erakdago.erakdagoapi.trip.model.Trip;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Chat {
    private UUID id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Trip trip;
    private List<Message> messages;
}
