package summer23.backend.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long song_id;

    @ManyToOne
    @JoinColumn(name="artist_id")
    private Artist artist;
    
    @ManyToOne
    @JoinColumn(name="genre_id")
    private Genre genre;

    @JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy ="song")
	private List<Note> notes;

    public Song() {
        super();
    }

    public Song(Artist artist, Genre genre) {
        this.artist = artist;
        this.genre = genre;
    }

    public Long getSong_id() {
        return song_id;
    }

    public void setSong_id(Long song_id) {
        this.song_id = song_id;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Song [song_id=" + song_id + "]";
    }

}
