package summer23.backend.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository<Song, Long> {
	// Find by song name
	List<Song> findBySong(String song);
		
	// Find by artist id
	List<Song> findByArtistId(Long id);
	
	// Find by artist name
	List<Song> findByArtistArtist(String artist);
	
	// Find by genre name
	List<Song> findByGenreGenre(String genre);

}