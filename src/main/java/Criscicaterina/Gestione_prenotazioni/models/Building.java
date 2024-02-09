package Criscicaterina.Gestione_prenotazioni.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Building {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private String address;
    private String city;
    @OneToMany(mappedBy = "building")
    private List<Workstation> workstations;

    @OneToMany(mappedBy = "building")
    private List<Booking> bookings;

}
