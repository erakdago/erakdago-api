package org.erakdago.erakdagoapi.model;

import lombok.*;

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
    private List<Review> reviewsLeft;
    private List<Favorite> favoriteTowns;
    private List<Post> posts;
    private List<Comment> comments;
    private List<Like> likes;
}
