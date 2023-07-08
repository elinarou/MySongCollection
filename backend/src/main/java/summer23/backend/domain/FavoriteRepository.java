package summer23.backend.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface FavoriteRepository extends CrudRepository<Favorite, Long> {
    // Find by customer id
	List<Favorite> findByCustomerId(Long id);

}