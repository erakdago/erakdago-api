package org.erakdago.erakdagoapi.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Region {
    private UUID id;
    private String name;
    private String description;
    private String climate;
    private String image;
    private List<Challenge> challengesAvailable;
}
