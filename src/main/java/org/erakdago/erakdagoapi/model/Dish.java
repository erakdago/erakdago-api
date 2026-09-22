package org.erakdago.erakdagoapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dish {
    private UUID id;
    private String name;
    private String description;
    private String origin;
    private String history;
    private String image;
    private UUID townId; // FK -> Town.id
    private UUID restorationId; // FK -> Restoration.id
    private List<Ingredient> ingredients;
}