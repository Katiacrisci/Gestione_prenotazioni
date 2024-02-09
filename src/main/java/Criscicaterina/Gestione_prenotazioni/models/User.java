package Criscicaterina.Gestione_prenotazioni.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    private String username;
    private String fullName;
    private String email;

    @OneToMany
    private List<Booking> bookings;

}
