package org.erakdago.erakdagoapi.model;

import lombok.*;

import java.time.LocalTime;
import java.util.List;

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
    private List<Dish> dishes;
}
