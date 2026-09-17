package org.erakdago.erakdagoapi.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class Town {
    private UUID id;
    private String name;
    private String description;
    private List<String> images;
    private Set<Activity> activities;
}
