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

import summer23.backend.domain.Artist;
import summer23.backend.domain.ArtistRepository;

@RestController
public class ArtistRestController {

    @Autowired
    ArtistRepository artistRepository;

    // Return all artists
    @GetMapping("/api/artists")
    public Iterable<Artist> getArtists() {
        return artistRepository.findAll();
    }

    // Return one artist by id 
    @GetMapping("/api/artists/id/{id}")
    Optional<Artist> getArtist(@PathVariable Long id) {
        return artistRepository.findById(id);
    }

    // Add new artist
    @PostMapping("/api/artists")
    Artist newArtist(@RequestBody Artist newArtist) {
        return artistRepository.save(newArtist);
    }

    // Edit artist
    @PutMapping("/api/artists/{id}")
    Artist editArtist(@RequestBody Artist editedArtist, @PathVariable Long id) {
        editedArtist.setId(id);
        return artistRepository.save(editedArtist);
    }

    // Delete artist
    @DeleteMapping("/api/artists/{id}")
    public Iterable<Artist> deleteArtist(@PathVariable Long id) {
        artistRepository.deleteById(id);
        return artistRepository.findAll();
    }
}