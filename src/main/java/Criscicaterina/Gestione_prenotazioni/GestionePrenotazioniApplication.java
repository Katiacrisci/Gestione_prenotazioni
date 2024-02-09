package Criscicaterina.Gestione_prenotazioni;

import Criscicaterina.Gestione_prenotazioni.models.Building;
import Criscicaterina.Gestione_prenotazioni.models.User;
import Criscicaterina.Gestione_prenotazioni.models.Workstation;
import Criscicaterina.Gestione_prenotazioni.models.WorkstationType;
import Criscicaterina.Gestione_prenotazioni.service.BookingService;
import Criscicaterina.Gestione_prenotazioni.service.BuildingService;
import Criscicaterina.Gestione_prenotazioni.service.UserService;
import Criscicaterina.Gestione_prenotazioni.service.WorkstationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class GestionePrenotazioniApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionePrenotazioniApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(BookingService bookingService, UserService userService, WorkstationService workstationService, BuildingService buildingService) {
		return args -> {
			userService.save(User.builder()
					.username("user1")
					.fullName("Mario Rossi")
					.email("user1@example.com")
					.build());
			userService.save(User.builder()
					.username("user2")
					.fullName("Marta verdi")
					.email("user2@example.com")
					.build());

			Building building1 = Building.builder()
					.address("Via Giuseppe Garibaldi")
					.city("Napoli")
					.name("Palazzo1")
					.build();
			Building building2 = Building.builder()
					.address("Via Giuseppe Mazzini")
					.city("Foggia")
					.name("Palazzo2")
					.build();

			Workstation w1 = Workstation.builder()
					.building(building1)
					.capacity(10)
					.type(WorkstationType.PRIVATE)
					.isFree(true)
					.description("workstation1: private")
					.build();
			Workstation w2 = Workstation.builder()
					.building(building2)
					.capacity(15)
					.type(WorkstationType.OPEN_SPACE)
					.isFree(true)
					.description("workstation2: Open_space")
					.build();
			Workstation w3 = Workstation.builder()
					.building(building2)
					.capacity(8)
					.type(WorkstationType.CONFERENCE_ROOM)
					.isFree(true)
					.description("workstation3: conference_room")
					.build();
			Workstation w4 = Workstation.builder()
					.building(building2)
					.capacity(5)
					.type(WorkstationType.PRIVATE)
					.isFree(true)
					.description("workstation4: private")
					.build();

			building1.setWorkstations(List.of(w1));
			buildingService.save(building1);

			building2.setWorkstations(List.of(w2, w3, w4));
			buildingService.save(building2);

			workstationService.save(w1);
			workstationService.save(w2);
			workstationService.save(w3);
			workstationService.save(w4);

//			User1 searches for workstations in Foggia of type private
			List<Workstation> result = workstationService.findWorkstations(WorkstationType.PRIVATE, "Foggia");
			result.forEach(System.out::println);

			User user1 = userService.findById(1L);

			result.stream()
					.findAny()
					.ifPresent(workstation -> bookingService.bookPlace(user1, workstation, LocalDate.now().plusDays(1)));






		};
	}


}
