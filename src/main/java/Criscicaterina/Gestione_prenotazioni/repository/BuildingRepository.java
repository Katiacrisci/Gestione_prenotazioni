package Criscicaterina.Gestione_prenotazioni.repository;

import Criscicaterina.Gestione_prenotazioni.models.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {
}
