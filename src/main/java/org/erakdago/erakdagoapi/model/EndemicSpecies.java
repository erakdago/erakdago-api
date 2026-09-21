package org.erakdago.erakdagoapi.model;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EndemicSpecies {
    public enum ConservationStatus {
        CR, EN, VU, NT, LC, DD, NE
    }

    private UUID id;
    private String localName;
    private String scientificName;
    private String description;
    private String habitat;
    private ConservationStatus conservationStatus;
    private List<String> images;
}
