package org.erakdago.erakdagoapi.model;

import lombok.*;

import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Restoration extends Service {
    private String cuisineType;
    private LocalTime openingHours;
    private LocalTime closingHours;
    private String menu;
}
