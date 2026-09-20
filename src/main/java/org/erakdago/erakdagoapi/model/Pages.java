package org.erakdago.erakdagoapi.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pages {
    private UUID id;
    private String order;
    private String title;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private UUID diaryId;
}
