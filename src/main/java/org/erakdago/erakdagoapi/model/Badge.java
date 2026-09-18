package org.erakdago.erakdagoapi.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class Badge {
    private UUID id;
    private String name;
    private String description;
    private Date createdAt;
    private String icon;
}
