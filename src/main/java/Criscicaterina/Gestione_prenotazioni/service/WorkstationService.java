package Criscicaterina.Gestione_prenotazioni.service;

import Criscicaterina.Gestione_prenotazioni.models.Workstation;
import Criscicaterina.Gestione_prenotazioni.models.WorkstationType;
import Criscicaterina.Gestione_prenotazioni.repository.WorkstationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkstationService {
    @Autowired
    private WorkstationRepository workstationRepository;

    public List<Workstation> findWorkstations(WorkstationType type, String city) {
       return workstationRepository.findWorkstationsByWorkstationTypeAndCity(type, city);
    }

    public void save(Workstation workstation) {
        workstationRepository.save(workstation);
    }
}
