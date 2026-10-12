package org.erakdago.erakdagoapi.destination.controller;

import lombok.RequiredArgsConstructor;
import org.erakdago.erakdagoapi.destination.model.Region;
import org.erakdago.erakdagoapi.destination.model.Town;
import org.erakdago.erakdagoapi.destination.service.RegionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/regions")
public class RegionController {
    private final RegionService regionService;

    @GetMapping
    public List<Region> getRegions(){
        return regionService.getRegions();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Region> getRegionById(@PathVariable UUID id) {
        return regionService.getRegionById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
