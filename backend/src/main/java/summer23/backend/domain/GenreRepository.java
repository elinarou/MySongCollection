package summer23.backend.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface GenreRepository extends CrudRepository<Genre, Long> {
	// Find by genre name
	List<Genre> findByName(String name);

}