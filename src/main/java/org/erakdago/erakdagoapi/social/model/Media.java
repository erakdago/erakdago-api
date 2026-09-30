package org.erakdago.erakdagoapi.social.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Media {
    public enum MediaType{
        IMAGE,
        VIDEO,
        AUDIO
    }
    private UUID id;
    private String title;
    private MediaType type;
    private String url;
    private String description;
    private LocalDate createdAt;
    private String content;
}
