package org.erakdago.erakdagoapi.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hotel extends Service{
    private int numberOfRooms;
    private String roomType;
    private int starRating;
    private String amenities;
}
