package summer23.backend.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import summer23.backend.domain.InstrumentRepository;
import summer23.backend.domain.Note;
import summer23.backend.domain.NoteRepository;
import summer23.backend.domain.SongRepository;
import summer23.backend.domain.TypeRepository;

@Controller
public class NoteController {
	
	@Autowired
	private NoteRepository noteRepository;

    @Autowired
	private SongRepository songRepository;
	
	@Autowired
	private InstrumentRepository instrumentRepository;

	@Autowired
	private TypeRepository typeRepository;
	
	// Show all sheet music
	@RequestMapping(value= {"/sheetmusiclist"})
	public String listSheetMusic(Model model) {
		model.addAttribute("notes", noteRepository.findAll());
		return "sheetmusiclist";
	}

    // Show song id's sheet music
    @GetMapping("/songsheetmusic/{id}")
    public String listSongSheetMusic(@PathVariable("id") Long songId, Model model) {
        model.addAttribute("notes", noteRepository.findBySongId(songId));
        return "songsheetmusic";
    }
	
	// Add new sheet music
	@RequestMapping(value = "/addnote")
	public String addNote(Model model){
		model.addAttribute("note", new Note());
        model.addAttribute("songs", songRepository.findAll());
		model.addAttribute("types", typeRepository.findAll());
		model.addAttribute("instruments", instrumentRepository.findAll());
		return "addnote";
	}
	
	// Save new sheet music
	@PostMapping("/savenote")
	public String saveNote(Note note){
		noteRepository.save(note);
		return "redirect:sheetmusiclist";
	}
	
	// Delete sheet music
	@GetMapping("/deletenote/{id}")
	public String deleteNote(@PathVariable("id") Long noteId, Model model){ 
		noteRepository.deleteById(noteId);
		return "redirect:../sheetmusiclist";
	}
	
	// Edit sheet music
	@GetMapping("/editnote/{id}")
	public String editNote(Note song, @PathVariable("id") Long noteId, Model model){ 
		model.addAttribute("note", noteRepository.findById(noteId));
        model.addAttribute("songs", songRepository.findAll());
		model.addAttribute("types", typeRepository.findAll());
		model.addAttribute("instruments", instrumentRepository.findAll());
		return "editnote";
	}
 
}