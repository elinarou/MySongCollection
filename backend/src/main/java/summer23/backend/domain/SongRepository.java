package summer23.backend.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository<Song, Long> {
	// Find by song name
	List<Song> findBySong(String song);
	
	// Find by artist
	List<Song> findByArtistArtist(String artist);
	
	// Find by genre
	List<Song> findByGenreGenre(String genre);

}