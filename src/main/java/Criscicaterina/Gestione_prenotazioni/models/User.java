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
@Table(name = "users")
@ToString
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    private String username;
    private String fullName;
    private String email;

    @OneToMany
    @ToString.Exclude
    private List<Booking> bookings;


}
