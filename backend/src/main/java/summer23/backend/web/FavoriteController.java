package summer23.backend.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import summer23.backend.domain.CustomerRepository;
import summer23.backend.domain.Favorite;
import summer23.backend.domain.FavoriteRepository;
import summer23.backend.domain.NoteRepository;



@Controller
public class FavoriteController {
	
    @Autowired
	private FavoriteRepository favoriteRepository;

	@Autowired
	private CustomerRepository customerRepository;

    @Autowired
	private NoteRepository noteRepository;
	
	// Show all favorites
	@RequestMapping(value= {"/favoritelist"})
	public String listFavorites(Model model) {
		model.addAttribute("favorites", favoriteRepository.findAll());
		return "favoritelist";
	}

    // Show customer id's favorites
    @GetMapping("/customerfavoritelist/{id}")
    public String listCustomerFavorites(@PathVariable("id") Long customerId, Model model) {
        model.addAttribute("favorites", favoriteRepository.findByCustomerId(customerId));
    	return "customerfavoritelist";
    }
	
	// Add new favorite
	@RequestMapping(value = "/addfavorite")
	public String addNote(Model model){
		model.addAttribute("favorite", new Favorite());
        model.addAttribute("customers", customerRepository.findAll());
		model.addAttribute("notes", noteRepository.findAll());
		return "addfavorite";
	}
	
	// Save new favorite
	@PostMapping("/savefavorite")
	public String saveFavorite(Favorite favorite, Model model){
		favoriteRepository.save(favorite);
		return "redirect:favoritelist";
	}
	
	// Delete favorite
	@GetMapping("/deletefavorite/{id}")
	public String deleteFavorite(@PathVariable("id") Long favoriteId, Model model){ 
		favoriteRepository.deleteById(favoriteId);
		return "redirect:../favoritelist";
	}
	
	// Edit favorite
	@GetMapping("/editfavorite/{id}")
	public String editFavorite(Favorite favorite, @PathVariable("id") Long favoriteId, Model model){ 
		model.addAttribute("favorite", favoriteRepository.findById(favoriteId));
        model.addAttribute("customers", customerRepository.findAll());
		model.addAttribute("notes", noteRepository.findAll());
		return "editfavorite";
	}
 
}
