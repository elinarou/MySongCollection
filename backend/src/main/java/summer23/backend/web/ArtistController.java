package summer23.backend.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

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
		return "addartist";
	}

	// // Search for existing artists
    // @GetMapping("/searchartist")
    // public String searchArtist(@PathVariable("name") String artistName, Model model) {
    //     model.addAttribute("artists", artistRepository.findByName(artistName));
    //     return "addsong";
    // }
	
	// Save new artist
	@PostMapping("/saveartist")
	public String saveArtist(Artist artist){
		artistRepository.save(artist);
		return "redirect:artistlist";
	}

	// Delete artist, if there's no songs
	@GetMapping("/deleteartist/{id}")
    public RedirectView deleteArtist(@PathVariable("id") Long artistId, RedirectAttributes attributes) {
        Optional<Artist> artist = artistRepository.findById(artistId);
        // From optional to normal
        Artist normalArtist = artist.get();
        if (normalArtist.getSongs().isEmpty()) {
            artistRepository.deleteById(artistId);
        } else {
            attributes.addFlashAttribute("error", "Artist can't be deleted since it has songs!");
        }
        return new RedirectView("/artistlist");
    }
	
	// Edit artist
	@GetMapping("/editartist/{id}")
	public String editArtist(Artist artist, @PathVariable("id") Long artistId, Model model){ 
		model.addAttribute("artist", artistRepository.findById(artistId));
		return "editartist";
	}
 
}