package Criscicaterina.Gestione_prenotazioni.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Workstation {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    private String description;
    private WorkstationType type;
    private Integer capacity;
    private Boolean isFree;
    @ManyToOne
    private Building building;


}
