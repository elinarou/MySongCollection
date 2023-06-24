package summer23.backend.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface InstrumentRepository extends CrudRepository<Instrument, Long> {
	// Find by instrument name
	List<Genre> findByInstrument(String instrument);

}