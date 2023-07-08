package summer23.backend.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;

@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 1, max = 200, message = "This field is required and cannot be empty.")
    private String url;

    @ManyToOne
    private Song song;

    @ManyToOne
    private Instrument instrument;
    
    @ManyToOne
    private Type type;

    @ManyToOne
    private Favorite favorite;

    public Note() {
        super();
    }

    public Note(String url, Song song, Instrument instrument, Type type, Favorite favorite) {
        this.url = url;
        this.song = song;
        this.instrument = instrument;
        this.type = type;
        this.favorite = favorite;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Favorite getFavorite() {
        return favorite;
    }

    public void setFavorite(Favorite favorite) {
        this.favorite = favorite;
    }

    @Override
    public String toString() {
        return "Note [id=" + id + ", url=" + url +"]";
    } 

}
