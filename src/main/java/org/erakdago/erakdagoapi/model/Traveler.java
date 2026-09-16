package org.erakdago.erakdagoapi.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Traveler extends User{
    private String preferences;
    private String localisation;
    private List<Reservation> reservationHistory;
    private List<Trip> trips = new ArrayList<>();

    public Traveler(UUID id, String firstName, String lastName, String username, String phoneNumber, String email, String password, String pfp, String description, LocalDateTime registrationDate, String status) {
        super(id, firstName, lastName, username, phoneNumber, email, password, pfp, description, registrationDate, status);
    }
}
