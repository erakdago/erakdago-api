package org.erakdago.erakdagoapi.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Transportation extends Service {
    private String transportType;
    private String departureLocation;
    private String arrivalLocation;
    private int capacity;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
}
