package org.erakdago.erakdagoapi.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Hotel extends Service{
    private int numberOfRooms;
    private String roomType;
    private int starRating;
    private String amenities;
    private int maxPrice;
    private int minPrice;
}
