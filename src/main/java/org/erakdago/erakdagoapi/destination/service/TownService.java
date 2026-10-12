package org.erakdago.erakdagoapi.destination.service;

import org.erakdago.erakdagoapi.destination.model.Town;
import org.erakdago.erakdagoapi.destination.repository.TownRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TownService {
    private final TownRepository townRepository;
    public TownService(TownRepository townRepository) {
        this.townRepository = townRepository;
    }
    public List<Town> getTowns() {
        return townRepository.findTowns();
    }
    public Optional<Town> getTownById(UUID id) {
        return townRepository.findTownById(id);
    }
}
