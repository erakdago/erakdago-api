package org.erakdago.erakdagoapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private UUID id;
    private String content;
    private LocalDateTime sendAt;
    private String type;
    private String status;
    private UUID chatId; // FK -> Chat.id
    private UUID userId; // FK -> Traveler.id
}
