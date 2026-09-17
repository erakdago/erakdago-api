package org.erakdago.erakdagoapi.model;

import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.util.UUID;

@Getter
@Setter
public class Activity {

    public enum ActivityDifficulty{
        EASY,MEDIUM,DIFFICULTY
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

}

