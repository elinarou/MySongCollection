package summer23.backend.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ArtistRepository extends CrudRepository<Artist, Long> {
	// Find by artist name
	List<Artist> findByName(String name);
    
}
