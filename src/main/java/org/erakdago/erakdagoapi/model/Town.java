package org.erakdago.erakdagoapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Town {
    private UUID id;
    private String name;
    private String description;
    private List<String> images;
    private Set<Activity> activities;
    private List<Review> reviews;
    private List<CulturalElement> culturalElements;
    private UUID regionId; // FK -> Region.id
    private List<Species> endemicSpecies;
    private List<Service> services;
}
