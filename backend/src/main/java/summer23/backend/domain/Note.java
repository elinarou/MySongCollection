package summer23.backend.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String version;

    @ManyToOne
    private Song song;

    @ManyToOne
    private Instrument instrument;
    
    @ManyToOne
    private Type type;

    @JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy ="fileModel")
	private List<FileModel> fileModels;

    public Note() {
        super();
    }

    public Note(String version, Song song, Instrument instrument, Type type) {
        this.version = version;
        this.song = song;
        this.instrument = instrument;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
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

    public List<FileModel> getFileModels() {
		return fileModels;
	}

	public void setFileModels(List<FileModel> fileModels) {
		this.fileModels = fileModels;
	}

    @Override
    public String toString() {
        return "Note [id=" + id + ", version=" + version +"]";
    } 

}
