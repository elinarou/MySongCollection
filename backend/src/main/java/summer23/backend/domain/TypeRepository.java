package summer23.backend.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TypeRepository extends CrudRepository<Type, Long> {
	// Find by Type name
	List<Type> findByName(String name);

}
