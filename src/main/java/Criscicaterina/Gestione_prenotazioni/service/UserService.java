package Criscicaterina.Gestione_prenotazioni.service;

import Criscicaterina.Gestione_prenotazioni.models.User;
import Criscicaterina.Gestione_prenotazioni.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}
