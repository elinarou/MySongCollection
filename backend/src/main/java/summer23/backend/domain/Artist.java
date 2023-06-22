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
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long artist_id;
    private String artist;

    @JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy ="artist")
	private List<Song> songs;

    public Artist() {
        super();
    }

    public Artist(String artist) {
        this.artist = artist;
    }

    public Long getArtist_id() {
        return artist_id;
    }

    public void setArtist_id(Long artist_id) {
        this.artist_id = artist_id;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

    @Override
    public String toString() {
        return "Artist [artist_id=" + artist_id + ", artist=" + artist + "]";
    }

}
