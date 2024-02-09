package Criscicaterina.Gestione_prenotazioni.service;

import Criscicaterina.Gestione_prenotazioni.models.Booking;
import Criscicaterina.Gestione_prenotazioni.models.User;
import Criscicaterina.Gestione_prenotazioni.models.Workstation;
import Criscicaterina.Gestione_prenotazioni.repository.BookingRepository;
import Criscicaterina.Gestione_prenotazioni.repository.WorkstationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private WorkstationRepository workstationRepository;

    public Optional<Booking> bookPlace(User user, Workstation workstation, LocalDate date) {
        if (!workstation.getIsFree()) {
            System.err.printf("Workstation %d already booked for %s\n", workstation.getId(), date.toString());
            return Optional.empty();
        }

        if (user.getBookings().stream().anyMatch(booking -> booking.getDate().equals(date))) {
            System.err.printf("user %s already has a booking for date %s \n", user.getUsername(), date);
            return Optional.empty();
        }
        workstation.setIsFree(false);
        Booking booking = Booking.builder()
                .user(user)
                .date(date)
                .building(workstation.getBuilding())
                .build();

        workstationRepository.save(workstation);
        bookingRepository.save(booking);
        System.out.printf("User %s booked successfully workstation %d for date %s \n", user.getUsername(), workstation.getId(), date.toString());

        return Optional.of(booking);

    }
}
