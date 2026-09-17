package org.erakdago.erakdagoapi.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Transportation extends Service {
    private String transportType;
    private String departureLocation;
    private String arrivalLocation;
    private int capacity;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
}
