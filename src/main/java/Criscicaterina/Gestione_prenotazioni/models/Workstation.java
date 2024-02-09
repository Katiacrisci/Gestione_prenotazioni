package Criscicaterina.Gestione_prenotazioni.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class Workstation {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    private String description;
    private WorkstationType type;
    private Integer capacity;
    private Boolean isFree;


}
