package org.erakdago.erakdagoapi.model;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public class Town{
    private UUID id;
    private String name;
    private String description;
    private List<String> images;
    private Set<Activity> activities;
}
