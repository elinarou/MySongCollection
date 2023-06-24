package summer23.backend.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ArtistRepository extends CrudRepository<Artist, Long> {
	// Find by Artist name
	List<Artist> findByArtist(String artist);
    
}
