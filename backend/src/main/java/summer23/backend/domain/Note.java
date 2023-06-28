package summer23.backend.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

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

	@OneToOne
	private FileModel fileModel;

    public Note() {
        super();
    }

    public Note(String version, Song song, Instrument instrument, Type type, FileModel fileModel) {
        this.version = version;
        this.song = song;
        this.instrument = instrument;
        this.type = type;
        this.fileModel = fileModel;
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

    public FileModel getFileModel() {
		return fileModel;
	}

	public void setFileModel(FileModel fileModel) {
		this.fileModel = fileModel;
	}

    @Override
    public String toString() {
        return "Note [id=" + id + ", version=" + version +"]";
    } 

}
