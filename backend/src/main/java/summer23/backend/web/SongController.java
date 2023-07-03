package summer23.backend.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import jakarta.validation.Valid;
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
	@RequestMapping(value= {"/songlist"})
	public String listSongs(Model model) {
		model.addAttribute("songs", songRepository.findAll());
		return "songlist";
	}

	// Show artist id's songs
    @GetMapping("/artistsonglist/{id}")
    public String listArtistSonglist(@PathVariable("id") Long artistId, Model model) {
        model.addAttribute("songs", songRepository.findByArtistId(artistId));
        return "artistsonglist";
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
	public String saveSong(@Valid @ModelAttribute("song") Song song, BindingResult bindingResult, Model model){
		if (bindingResult.hasErrors()) {
			model.addAttribute("artists", artistRepository.findAll());
			model.addAttribute("genres", genreRepository.findAll());
			return "editsong";
		}
		songRepository.save(song);
		return "redirect:songlist";
	}
	
	// Delete Song, if there's sheet music
	@GetMapping("/deletesong/{id}")
    public RedirectView deleteSong(@PathVariable("id") Long songId, RedirectAttributes attributes) {
        Optional<Song> song = songRepository.findById(songId);
        // From optional to normal
        Song normalSong = song.get();
        if (normalSong.getNotes().isEmpty()) {
            songRepository.deleteById(songId);
        } else {
            attributes.addFlashAttribute("error", "Song can't be deleted since it has sheet music!");
        }
        return new RedirectView("/songlist");
    }
	
	// Edit song
	@GetMapping("/editsong/{id}")
	public String editSong(Song song, @PathVariable("id") Long songId, Model model){ 
		model.addAttribute("song", songRepository.findById(songId));
		model.addAttribute("artists", artistRepository.findAll());
		model.addAttribute("genres", genreRepository.findAll());
		return "editsong";
	}
 
}