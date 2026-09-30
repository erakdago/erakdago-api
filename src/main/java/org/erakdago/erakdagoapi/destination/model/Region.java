package org.erakdago.erakdagoapi.destination.model;

import lombok.*;

import org.erakdago.erakdagoapi.gamification.model.Challenge;

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
