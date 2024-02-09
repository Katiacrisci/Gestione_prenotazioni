package Criscicaterina.Gestione_prenotazioni.service;

import Criscicaterina.Gestione_prenotazioni.models.Booking;
import Criscicaterina.Gestione_prenotazioni.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    public void save(Booking booking) {
        bookingRepository.save(booking);
    }

//    public Booking bookPlace(User user, Workstation workstation) {
//
//    }
}
