package Criscicaterina.Gestione_prenotazioni.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
