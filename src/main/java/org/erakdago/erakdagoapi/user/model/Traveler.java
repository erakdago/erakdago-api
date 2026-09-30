package org.erakdago.erakdagoapi.user.model;

import lombok.*;

import org.erakdago.erakdagoapi.gamification.model.CheckIn;
import org.erakdago.erakdagoapi.reservation.model.Reservation;
import org.erakdago.erakdagoapi.social.model.Comment;
import org.erakdago.erakdagoapi.social.model.Like;
import org.erakdago.erakdagoapi.social.model.Post;
import org.erakdago.erakdagoapi.social.model.Review;
import org.erakdago.erakdagoapi.trip.model.Trip;
import org.erakdago.erakdagoapi.trip.model.TripInvitation;
import org.erakdago.erakdagoapi.trip.model.TripProposal;

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
    private List<TripInvitation> tripInvitations;
    private List<TripProposal> tripProposals;
    private List<CheckIn> checkIns;
}
