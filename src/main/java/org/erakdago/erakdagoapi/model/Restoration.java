package org.erakdago.erakdagoapi.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
public class Restoration extends Service {
    private String cuisineType;
    private LocalTime openingHours;
    private LocalTime closingHours;
    private String menu;
}
