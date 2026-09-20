package org.erakdago.erakdagoapi.model;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Region {
    private UUID id;
    private String name;
    private String description;
    private String climate;
    private String image;
    private List<Challenge> challengesAvailable;
    private List<Town> towns;
}
