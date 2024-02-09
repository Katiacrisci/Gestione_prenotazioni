package Criscicaterina.Gestione_prenotazioni.repository;

import Criscicaterina.Gestione_prenotazioni.models.Workstation;
import Criscicaterina.Gestione_prenotazioni.models.WorkstationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkstationRepository extends JpaRepository<Workstation, Long> {

    @Query("SELECT w FROM Workstation w WHERE w.type = :type AND w.building.city = :city")
     List<Workstation> findWorkstationsByWorkstationTypeAndCity(WorkstationType type, String city);


}
