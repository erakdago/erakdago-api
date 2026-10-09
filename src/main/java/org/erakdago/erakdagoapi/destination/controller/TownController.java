package org.erakdago.erakdagoapi.destination.controller;

import lombok.RequiredArgsConstructor;
import org.erakdago.erakdagoapi.destination.model.Town;
import org.erakdago.erakdagoapi.destination.service.TownService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/towns")
public class TownController {
    private final TownService townService;


    @GetMapping
    public List<Town> getTowns() {
        return townService.getTowns();
    }
}
