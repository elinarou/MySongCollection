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

import summer23.backend.domain.Song;
import summer23.backend.domain.SongRepository;

@RestController
public class SongRestController {

    @Autowired
    SongRepository songRepository;

    // Return all songs
    @GetMapping("/api/songs")
    public Iterable<Song> getSongs() {
        return songRepository.findAll();
    }

    // Return one song by id 
    @GetMapping("/api/songs/id/{id}")
    Optional<Song> getSong(@PathVariable Long id) {
        return songRepository.findById(id);
    }

    // Return songs by name 
    @GetMapping("/api/songs/name/{name}")
    Iterable<Song> getSongByName(@PathVariable String name) {
        return songRepository.findByName(name);
    }

    // Return songs by artist name 
    @GetMapping("/api/songs/artist/name/{name}")
    Iterable<Song> getSongByArtistName(@PathVariable String name) {
        return songRepository.findByArtistName(name);
    }

    // Return songs by artist id 
    @GetMapping("/api/songs/artist/id/{id}")
    Iterable<Song> getSongByArtistId(@PathVariable Long id) {
        return songRepository.findByArtistId(id);
    }

    // Add new song
    @PostMapping("/api/songs")
    Song newSong(@RequestBody Song newSong) {
        return songRepository.save(newSong);
    }

    // Edit song
    @PutMapping("/api/songs/{id}")
    Song editSong(@RequestBody Song editedSong, @PathVariable Long id) {
        editedSong.setId(id);
        return songRepository.save(editedSong);
    }

    // Delete song
    @DeleteMapping("/api/songs/{id}")
    public Iterable<Song> deleteSong(@PathVariable Long id) {
        songRepository.deleteById(id);
        return songRepository.findAll();
    }
}