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
	
	// Show notelist
	@RequestMapping(value= {"/notelist"})
	public String notelist(Model model) {
		model.addAttribute("notes", noteRepository.findAll());
		return "notelist";
	}
	
	// Add new note
	@RequestMapping(value = "/addnote")
	public String addSong(Model model){
		model.addAttribute("note", new Note());
        model.addAttribute("songs", songRepository.findAll());
		model.addAttribute("types", typeRepository.findAll());
		model.addAttribute("instruments", instrumentRepository.findAll());
		return "addnote";
	}
	
	// Save new note
	@PostMapping("/save")
	public String save(Note note){
		noteRepository.save(note);
		return "redirect:notelist";
	}
	
	// Delete note
	@GetMapping("/delete/{id}")
	public String deleteSong(@PathVariable("note_id") Long noteid, Model model){ 
		noteRepository.deleteById(noteid);
		return "redirect:../notelist";
	}
	
	// Edit note
	@GetMapping("/editnote/{id}")
	public String editNote(Note song, @PathVariable("note_id") Long noteid, Model model){ 
		model.addAttribute("note", noteRepository.findById(noteid));
        model.addAttribute("songs", songRepository.findAll());
		model.addAttribute("types", typeRepository.findAll());
		model.addAttribute("instruments", instrumentRepository.findAll());
		return "editnote";
	}
 
}