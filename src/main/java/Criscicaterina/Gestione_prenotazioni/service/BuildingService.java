package Criscicaterina.Gestione_prenotazioni.service;

import Criscicaterina.Gestione_prenotazioni.models.Building;
import Criscicaterina.Gestione_prenotazioni.repository.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuildingService {
    @Autowired
    private BuildingRepository buildingRepository;

    public void save(Building building) {
        buildingRepository.save(building);

    }
}

