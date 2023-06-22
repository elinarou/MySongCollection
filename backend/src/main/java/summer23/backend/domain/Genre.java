package summer23.backend.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long genre_id;
    private String genre;

    @JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy ="genre")
	private List<Song> songs;

    public Genre() {
        super();
    }

    public Genre(String genre) {
        this.genre = genre;
    }

    public Long getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(Long genre_id) {
        this.genre_id = genre_id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

    @Override
    public String toString() {
        return "Genre [genre_id=" + genre_id + ", genre=" + genre + "]";
    }

}
