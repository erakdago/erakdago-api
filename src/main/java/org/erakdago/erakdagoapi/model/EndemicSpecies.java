package org.erakdago.erakdagoapi.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class EndemicSpecies {
    public enum ConservationStatus {
        CR, EN, VU, NT, LC, DD, NE
    }

    private UUID id;
    private String localNane;
    private String scientificName;
    private String description;
    private String habitat;
    private ConservationStatus conservationStatus;
    private List<String> images;
}
