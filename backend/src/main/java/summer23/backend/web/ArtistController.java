package summer23.backend.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import summer23.backend.domain.Artist;
import summer23.backend.domain.ArtistRepository;

@Controller
public class ArtistController {
	
    @Autowired
	private ArtistRepository artistRepository;
	
	// Show artistlist
	@RequestMapping(value= {"/", "/artistlist"})
	public String listArtist(Model model) {
		model.addAttribute("artists", artistRepository.findAll());
		return "artistlist";
	}
	
	// Add new artist
	@RequestMapping(value = "/addartist")
	public String addArtist(Model model){
		model.addAttribute("artist", new Artist());
		return "addArtist";
	}
	
	// Save new artist
	@PostMapping("/saveartist")
	public String saveArtist(Artist artist){
		artistRepository.save(artist);
		return "redirect:artistlist";
	}
	
	// Delete artist
	@GetMapping("/deleteartist/{id}")
	public String deleteArtist(@PathVariable("id") Long artistId, Model model){ 
		artistRepository.deleteById(artistId);
		return "redirect:../artistlist";
	}
	
	// Edit artist
	@GetMapping("/editartist/{id}")
	public String editArtist(Artist artist, @PathVariable("id") Long artistId, Model model){ 
		model.addAttribute("artist", artistRepository.findById(artistId));
		return "editartist";
	}
 
}