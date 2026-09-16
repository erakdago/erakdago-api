package org.erakdago.erakdagoapi.model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Destination {
    private UUID id;
    private String name;
    private String description;
    private String image;
    private LocalTime bestTimeToVisit;
    private List<Trip> trips = new ArrayList<>();
}
