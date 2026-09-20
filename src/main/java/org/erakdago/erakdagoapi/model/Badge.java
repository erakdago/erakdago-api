package org.erakdago.erakdagoapi.model;

import lombok.*;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Badge {
    private UUID id;
    private String name;
    private String description;
    private Date createdAt;
    private String icon;
}
