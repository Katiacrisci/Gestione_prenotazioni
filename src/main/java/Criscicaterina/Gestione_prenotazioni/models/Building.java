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
@ToString
public class Building {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private String address;
    private String city;
    @OneToMany(mappedBy = "building")
    @ToString.Exclude
    private List<Workstation> workstations;

    @OneToMany(mappedBy = "building")
    @ToString.Exclude
    private List<Booking> bookings;

}
