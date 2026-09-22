package org.erakdago.erakdagoapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class Species {
    private UUID id;
    private String localname;
    private String scientificName;
    private String description;
    private String habitat;
    private ConservationStatus conservationStatus;
    private List<String> images;
    private boolean isEndemic;
    private SpeciesType type;
    private UUID townId;
    public enum ConservationStatus {
        CR, EN, VU, NT, LC, DD, NE
    }
    public enum SpeciesType {
            FAUNA,FLORA
    }
}
