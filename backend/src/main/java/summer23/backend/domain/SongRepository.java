package summer23.backend.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository<Song, Long> {
	// find by song name
	List<Song> findBySong(String song);
	
	// find by artist
	List<Song> findByArtistArtist(String artist);
	
	// find by genre
	List<Song> findByGenreGenre(String genre);

}