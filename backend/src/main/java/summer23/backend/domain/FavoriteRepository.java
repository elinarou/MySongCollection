package summer23.backend.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface FavoriteRepository extends CrudRepository<Favorite, Long> {
    // Find by customer id
	List<Favorite> findByCustomerId(Long id);

    // Find by customer username
	List<Favorite> findByCustomerUsername(String username);

    // Find by note id
	List<Favorite> findByNoteId(Long id);
}