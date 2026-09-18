package org.erakdago.erakdagoapi.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Achievement {
    private UUID id;
    private String name;
    private String description;
    private String criteria;
    private Date createdAt;
    private Badge badge;
    private List<Challenge> challengesRequired;
}
