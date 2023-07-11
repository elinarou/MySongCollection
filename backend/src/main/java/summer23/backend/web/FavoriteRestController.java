package summer23.backend.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import summer23.backend.domain.Favorite;
import summer23.backend.domain.FavoriteRepository;

@RestController
public class FavoriteRestController {

    @Autowired
    FavoriteRepository favoriteRepository;

    // Return all favorites
    @GetMapping("/api/favorites")
    public Iterable<Favorite> getFavorites() {
        return favoriteRepository.findAll();
    }

    // Return one favorite by id 
    @GetMapping("/api/favorites/id/{id}")
    Optional<Favorite> getFavorite(@PathVariable Long id) {
        return favoriteRepository.findById(id);
    }

    // Return favorite by note id 
    @GetMapping("/api/favorites/note/id/{id}")
    Iterable<Favorite> getFavoriteByNoteId(@PathVariable Long id) {
        return favoriteRepository.findByNoteId(id);
    }

    // Return favorite by customer id 
    @GetMapping("/api/favorites/customer/id/{id}")
    Iterable<Favorite> getFavoriteByCustomerId(@PathVariable Long id) {
        return favoriteRepository.findByCustomerId(id);
    }

    // Return favorite by customer username 
    @GetMapping("/api/favorites/customer/username/{username}")
    Iterable<Favorite> getFavoriteByUserame(@PathVariable String username) {
        return favoriteRepository.findByCustomerUsername(username);
    }

    // Add new favorite
    @PostMapping("/api/favorites")
    Favorite newFavorite(@RequestBody Favorite newFavorite) {
        return favoriteRepository.save(newFavorite);
    }

    // Edit favorite
    @PutMapping("/api/favorites/{id}")
    Favorite editFavorite(@RequestBody Favorite editedFavorite, @PathVariable Long id) {
        editedFavorite.setId(id);
        return favoriteRepository.save(editedFavorite);
    }

    // Delete favorite
    @DeleteMapping("/api/favorites/{id}")
    public Iterable<Favorite> deleteFavorite(@PathVariable Long id) {
        favoriteRepository.deleteById(id);
        return favoriteRepository.findAll();
    }
}