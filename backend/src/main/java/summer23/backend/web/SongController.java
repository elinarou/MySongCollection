package summer23.backend.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import summer23.backend.domain.ArtistRepository;
import summer23.backend.domain.GenreRepository;
import summer23.backend.domain.Song;
import summer23.backend.domain.SongRepository;

@Controller
public class SongController {
	
	@Autowired
	private SongRepository songRepository;

    @Autowired
	private ArtistRepository artistRepository;
	
	@Autowired
	private GenreRepository genreRepository;
	
	// Show songlist
	@RequestMapping(value= {"/", "/songlist"})
	public String songlist(Model model) {
		model.addAttribute("songs", songRepository.findAll());
		return "index";
	}
	
	// Add new song
	@RequestMapping(value = "/addsong")
	public String addSong(Model model){
		model.addAttribute("song", new Song());
		model.addAttribute("artists", artistRepository.findAll());
		model.addAttribute("genres", genreRepository.findAll());
		return "addsong";
	}
	
	// Save new song
	@PostMapping("/savesong")
	public String saveSong(Song song){
		songRepository.save(song);
		return "redirect:songlist";
	}
	
	// Delete song
	@GetMapping("/deletesong/{id}")
	public String deleteSong(@PathVariable("song_id") Long songId, Model model){ 
		songRepository.deleteById(songId);
		return "redirect:../songlist";
	}
	
	// Edit song
	@GetMapping("/editsong/{id}")
	public String editSong(Song song, @PathVariable("song_id") Long songId, Model model){ 
		model.addAttribute("song", songRepository.findById(songId));
		model.addAttribute("artists", artistRepository.findAll());
		model.addAttribute("genres", genreRepository.findAll());
		return "editsong";
	}
 
}