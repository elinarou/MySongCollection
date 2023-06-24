package summer23.backend.domain;

import org.springframework.data.repository.CrudRepository;

public interface AppUserRepository extends CrudRepository<AppUser, Long> {
	// Find by username
	AppUser findByUsername(String username);
    
}