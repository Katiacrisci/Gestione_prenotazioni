package Criscicaterina.Gestione_prenotazioni.repository;

import Criscicaterina.Gestione_prenotazioni.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(Long id);


}
