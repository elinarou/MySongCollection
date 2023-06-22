package summer23.backend.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<Note, Long> {
	// find by song
	List<Note> findBySongSong(String song);

    // find by type
	List<Note> findByTypeType(String type);
	
	// find by instrument
	List<Note> findByInstrumentInstrument(String instrument);

}
