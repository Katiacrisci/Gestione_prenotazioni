package Criscicaterina.Gestione_prenotazioni;

import Criscicaterina.Gestione_prenotazioni.models.User;
import Criscicaterina.Gestione_prenotazioni.service.BookingService;
import Criscicaterina.Gestione_prenotazioni.service.UserService;
import Criscicaterina.Gestione_prenotazioni.service.WorkstationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GestionePrenotazioniApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionePrenotazioniApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(BookingService bookingService, UserService userService, WorkstationService workstationService) {
		return args -> {
			userService.save(User.builder()
					.username("user1")
					.fullName("Mario Rossi")
					.email("user1@example.com")
					.build());

		};
	}


}
