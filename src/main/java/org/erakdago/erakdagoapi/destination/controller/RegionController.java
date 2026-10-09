package org.erakdago.erakdagoapi.destination.controller;

import lombok.RequiredArgsConstructor;
import org.erakdago.erakdagoapi.destination.model.Region;
import org.erakdago.erakdagoapi.destination.service.RegionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/regions")
public class RegionController {
    private final RegionService regionService;

    @GetMapping
    public List<Region> getRegions(){
        return regionService.getRegions();
    }
}
