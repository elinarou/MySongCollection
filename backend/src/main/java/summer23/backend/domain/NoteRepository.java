package summer23.backend.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<Note, Long> {
	// Find by song
	List<Note> findBySongSong(String song);

    // Find by type
	List<Note> findByTypeType(String type);
	
	// Find by instrument
	List<Note> findByInstrumentInstrument(String instrument);

}
