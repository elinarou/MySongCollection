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

import summer23.backend.domain.Note;
import summer23.backend.domain.NoteRepository;

@RestController
public class NoteRestController {

    @Autowired
    NoteRepository noteRepository;

    // Return all notes
    @GetMapping("/api/notes")
    public Iterable<Note> getNotes() {
        return noteRepository.findAll();
    }

    // Return one note by id 
    @GetMapping("/api/notes/id/{id}")
    Optional<Note> getNote(@PathVariable Long id) {
        return noteRepository.findById(id);
    }

    // Return notes by song id 
    @GetMapping("/api/notes/song/id/{id}")
    Iterable<Note> getNoteBySongId(@PathVariable Long id) {
        return noteRepository.findBySongId(id);
    }

    // Return notes by song name 
    @GetMapping("/api/notes/song/name/{name}")
    Iterable<Note> getNoteBySongName(@PathVariable String name) {
        return noteRepository.findBySongName(name);
    }

    // Return notes by artist name 
    @GetMapping("/api/notes/artist/name/{name}")
    Iterable<Note> getNoteByArtistName(@PathVariable String name) {
        return noteRepository.findBySongArtistName(name);
    }

    // Add new note
    @PostMapping("/api/notes")
    Note newNote(@RequestBody Note newNote) {
        return noteRepository.save(newNote);
    }

    // Edit note
    @PutMapping("/api/notes/{id}")
    Note editNote(@RequestBody Note editedNote, @PathVariable Long id) {
        editedNote.setId(id);
        return noteRepository.save(editedNote);
    }

    // Delete note
    @DeleteMapping("/api/notes/{id}")
    public Iterable<Note> deleteNote(@PathVariable Long id) {
        noteRepository.deleteById(id);
        return noteRepository.findAll();
    }
}