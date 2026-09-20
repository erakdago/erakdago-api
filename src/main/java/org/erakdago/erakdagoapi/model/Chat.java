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
public class Chat {
    private UUID id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Trip trip;
    private List<Message> messages;
}
