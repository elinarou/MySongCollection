package summer23.backend.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
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
	
	// Show all notes
	@RequestMapping(value= {"/sheetmusiclist"})
	public String listSheetMusic(Model model) {
		model.addAttribute("notes", noteRepository.findAll());
		return "sheetmusiclist";
	}

    // // Show song id's sheet music
    // @GetMapping("/songsheetmusic/{id}")
    // public String listSongSheetMusic(@PathVariable("id") Long songId, Model model) {
    //     model.addAttribute("notes", noteRepository.findBySongId(songId));
    //     return "songsheetmusic";
    // }
	
	// Add new note
	@RequestMapping(value = "/addnote")
	public String addNote(Model model){
		model.addAttribute("note", new Note());
        model.addAttribute("songs", songRepository.findAll());
		model.addAttribute("types", typeRepository.findAll());
		model.addAttribute("instruments", instrumentRepository.findAll());
		return "addnote";
	}
	
	// Save new note
	@PostMapping("/savenote")
	public String saveNote(@Valid @ModelAttribute("note") Note note, BindingResult bindingResult, Model model){
		if (bindingResult.hasErrors()) {
        model.addAttribute("songs", songRepository.findAll());
		model.addAttribute("types", typeRepository.findAll());
		model.addAttribute("instruments", instrumentRepository.findAll());
		return "editnote";
		}
		noteRepository.save(note);
		return "redirect:sheetmusiclist";
	}
	
	// Delete note
	@GetMapping("/deletenote/{id}")
	public String deleteNote(@PathVariable("id") Long noteId, Model model){ 
		noteRepository.deleteById(noteId);
		return "redirect:../sheetmusiclist";
	}
	
	// Edit note
	@GetMapping("/editnote/{id}")
	public String editNote(Note note, @PathVariable("id") Long noteId, Model model){ 
		model.addAttribute("note", noteRepository.findById(noteId));
        model.addAttribute("songs", songRepository.findAll());
		model.addAttribute("types", typeRepository.findAll());
		model.addAttribute("instruments", instrumentRepository.findAll());
		return "editnote";
	}
 
}