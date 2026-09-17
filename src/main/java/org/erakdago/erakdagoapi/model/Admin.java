package org.erakdago.erakdagoapi.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class Admin extends User {
    private String accessLevel;
    private Set<String> permissions;
}
