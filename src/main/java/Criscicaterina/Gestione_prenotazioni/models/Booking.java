package Criscicaterina.Gestione_prenotazioni.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Booking {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    private LocalDate date;

    @ManyToOne
    private Building building;

    @ManyToOne
    private User user;

}
