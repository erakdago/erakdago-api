package org.erakdago.erakdagoapi.destination.service;

import org.erakdago.erakdagoapi.destination.model.Region;
import org.erakdago.erakdagoapi.destination.repository.RegionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RegionService {
    private final RegionRepository regionRepository;
    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }
    public List<Region> getRegions() {
        return  regionRepository.findRegions();
    }
    public Optional<Region> getRegionById(UUID id) {
        return regionRepository.findRegionById(id);
    }
}
