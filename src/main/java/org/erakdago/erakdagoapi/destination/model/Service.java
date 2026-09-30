package org.erakdago.erakdagoapi.destination.model;

import lombok.*;

import org.erakdago.erakdagoapi.social.model.Review;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public abstract class Service {
    private UUID id;
    private String name;
    private String description;
    private String location;
    private String image;
    private String contactInformation;
    private boolean availability;
    private String status;
    private UUID townId; // FK -> Town.id
    private List<Review> reviewHistory;
    private int maxPrice;
    private int minPrice;
}
