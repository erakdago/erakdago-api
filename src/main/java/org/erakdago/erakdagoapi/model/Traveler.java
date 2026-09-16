package org.erakdago.erakdagoapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Traveler extends User {
    private String preferences;
    private String localisation;
    private List<Reservation> reservationHistory;
    private List<Trip> trips = new ArrayList<>();
}
