package org.erakdago.erakdagoapi.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public abstract class Service {
    private UUID id;
    private String name;
    private String description;
    private int price;
    private String location;
    private String image;
    private String contactInformation;
    private boolean availability;
    private String status;
    private UUID towndID; // FK -> towns.id
}
