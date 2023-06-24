package summer23.backend.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<Note, Long> {
	// Find by song id
	List<Note> findBySongId(Long id);

    // Find by type name
	List<Note> findByTypeType(String type);
	
	// Find by instrument name
	List<Note> findByInstrumentInstrument(String instrument);

}
