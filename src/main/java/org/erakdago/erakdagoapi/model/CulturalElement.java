package org.erakdago.erakdagoapi.model;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CulturalElement {
    private UUID id;
    private String name;
    private String description;
    private String type;
    private String historicalPeriod;
    private String culturalSignificance;
    private String image;
    private List<String> images;
    private UUID town; // FK -> Town.id
}
