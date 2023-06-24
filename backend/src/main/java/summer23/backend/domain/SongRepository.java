package summer23.backend.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository<Song, Long> {
	// Find by song name
	List<Song> findByName(String name);
		
	// Find by artist id
	List<Song> findByArtistId(Long id);
	
	// Find by artist name
	List<Song> findByArtistName(String name);
	
	// Find by genre name
	List<Song> findByGenreName(String name);

}