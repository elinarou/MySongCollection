package summer23.backend.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface FileModelRepository extends CrudRepository<FileModel, Long> {
    // Find by note id
	List<FileModel> findByNoteId(Long id);

}