package summer23.backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import summer23.backend.domain.AppUser;
import summer23.backend.domain.AppUserRepository;
import summer23.backend.domain.Artist;
import summer23.backend.domain.ArtistRepository;
import summer23.backend.domain.Genre;
import summer23.backend.domain.GenreRepository;
import summer23.backend.domain.Instrument;
import summer23.backend.domain.InstrumentRepository;
import summer23.backend.domain.Note;
import summer23.backend.domain.NoteRepository;
import summer23.backend.domain.Song;
import summer23.backend.domain.SongRepository;
import summer23.backend.domain.Type;
import summer23.backend.domain.TypeRepository;
import summer23.backend.domain.Customer;
import summer23.backend.domain.CustomerRepository;
import summer23.backend.domain.Favorite;
import summer23.backend.domain.FavoriteRepository;

@SpringBootApplication
public class BackendApplication {

	private static final Logger log = LoggerFactory.getLogger(BackendApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(
		SongRepository songRepository, 
		NoteRepository noteRepository,
		GenreRepository genreRepository,
		ArtistRepository artistRepository, 
		InstrumentRepository instrumentRepository,
		TypeRepository typeRepository,
		AppUserRepository appUserRepository,
		CustomerRepository customerRepository,
		FavoriteRepository favoriteRepository) {
		return (args) -> {
			
			log.info("Users");
			appUserRepository.save(new AppUser("Maija", "Meikäläinen", "USER", "user",
					"$2a$10$57kg9OGuj44FPQyaps/fvOHmP845GQHIFdjphY4ILU/LoF1sVnQPS"));
			appUserRepository.save(new AppUser("Elina", "Rouvinen", "ADMIN", "admin",
					"$2a$10$7DJe9e5TiHD5hHpm029KKeVXE/waBITs/9ykEd1qhEfZZbaRVkRiW"));

			log.info("Genres");
			Genre genre1 = new Genre("Metal");
			Genre genre2 = new Genre("Pop");
			Genre genre3 = new Genre("Rock");
			genreRepository.save(genre1);
			genreRepository.save(genre2);
			genreRepository.save(genre3);

			log.info("Artists");
			Artist artist1 = new Artist("Sonata Arctica");
			Artist artist2 = new Artist("Twenty One Pilots");
			Artist artist3 = new Artist("Apulanta");
			artistRepository.save(artist1);
			artistRepository.save(artist2);
			artistRepository.save(artist3);
			
			log.info("Instruments");
			Instrument instru1 = new Instrument("Guitar");
			Instrument instru2 = new Instrument("Piano");
			Instrument instru3 = new Instrument("Ukulele");
			instrumentRepository.save(instru1);
			instrumentRepository.save(instru2);
			instrumentRepository.save(instru3);

			log.info("Types");
			Type type1 = new Type("Chords");
			Type type2 = new Type("Tabs");
			typeRepository.save(type1);
			typeRepository.save(type2);
			
			log.info("Songs");
			Song song1 = new Song("Black Sheep", artist1, genre1);
			Song song2 = new Song("House Of Gold", artist2, genre2);
			Song song3 = new Song("Ravistettava Ennen Käyttöä", artist3, genre3);
			Song song4 = new Song("Jumala", artist3, genre3);
			Song song5 = new Song("Broken", artist1, genre1);
			songRepository.save(song1);
			songRepository.save(song2);
			songRepository.save(song3);
			songRepository.save(song4);
			songRepository.save(song5);

			log.info("Sheet Music");
			Note note1 = new Note("https://www.google.com/", song1, instru1, type2);
			Note note2 = new Note("https://www.google.com/", song2, instru3, type1);
			Note note3 = new Note("https://www.google.com/", song3, instru1, type1);
			Note note4 = new Note("https://www.google.com/", song1, instru3, type1);
			Note note5 = new Note("https://www.google.com/", song4, instru1, type1);
			Note note6 = new Note("https://www.google.com/", song4, instru1, type1);
			Note note7 = new Note("https://www.google.com/", song5, instru3, type1);
			noteRepository.save(note1);
			noteRepository.save(note2);
			noteRepository.save(note3);
			noteRepository.save(note4);
			noteRepository.save(note5);
			noteRepository.save(note6);
			noteRepository.save(note7);
			
			log.info("Customers");
			Customer customer1 = new Customer("Jane", "jane@email.com");
			Customer customer2 = new Customer("John", "john@email.com");
			customerRepository.save(customer1);
			customerRepository.save(customer2);

			log.info("Favorites");
			Favorite favorite1 = new Favorite(customer1, note1);
			Favorite favorite2 = new Favorite(customer2, note2);
			Favorite favorite3 = new Favorite(customer2, note3);
			favoriteRepository.save(favorite1);
			favoriteRepository.save(favorite2);
			favoriteRepository.save(favorite3);
			
  		};
  	}

}
