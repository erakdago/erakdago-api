package org.erakdago.erakdagoapi.model;

import java.time.LocalDateTime;
import java.util.UUID;

public record Reservation (UUID id, LocalDateTime reservationDate, LocalDateTime startedTime, LocalDateTime endedTime, int numberOfPeople, String status, double totalPrice, String notes, UUID travelerId, UUID serviceId ) {
}
