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
public class Instrument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String instrument;

    @JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy ="instrument")
	private List<Note> notes;

    public Instrument() {
        super();
    }

    public Instrument(String instrument) {
        this.instrument = instrument;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

    @Override
    public String toString() {
        return "Instrument [id=" + id + ", instrument=" + instrument + "]";
    }

}
