package org.erakdago.erakdagoapi.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class CulturalElement {
    private UUID id;
    private String name;
    private String description;
    private String type;
    private String historicalPeriode;
    private String cultuiuralSignificance;
    private List<String> images;
    private UUID town; // FK -> Town.id
}
