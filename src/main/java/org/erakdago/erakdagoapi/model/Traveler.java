package org.erakdago.erakdagoapi.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Traveler extends User {
    private String preferences;
    private String localisation;
    private List<Reservation> reservationHistory;
    private List<Trip> trips = new ArrayList<>();
    private List<Review> reviewsLeft;
}
