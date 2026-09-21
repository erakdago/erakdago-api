package org.erakdago.erakdagoapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Activity {

    public enum ActivityDifficulty{
        EASY, MEDIUM, DIFFICULT
    }

    private UUID id;
    private String name;
    private String description;
    private Duration duration;
    private String type;
    private ActivityDifficulty difficulty;
    private int capacity;
    private int price;
    private boolean availability;
    private String image;
    private List<EndemicSpecies> endemicSpecies;
}
