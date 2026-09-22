package org.erakdago.erakdagoapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    private UUID id;
    private LocalDateTime createdAt;
    private LocalDateTime reservationDate;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int numberOfPeople;
    private String status;
    private double totalPrice;
    private String notes;
    private UUID travelerId; // FK -> Traveler.id
    private UUID serviceId; // FK -> Service.id
    private UUID activityId; // FK -> Activity.id
}