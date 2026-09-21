package org.erakdago.erakdagoapi.model;

import lombok.*;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Achievement {
    private UUID id;
    private String name;
    private String description;
    private String criteria;
    private Date createdAt;
    private Badge badge;
}
