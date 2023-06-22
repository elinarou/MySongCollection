package summer23.backend.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long note_id;

    private String note;

    @ManyToOne
    @JoinColumn(name="song_id")
    private Song song;

    @ManyToOne
    @JoinColumn(name="instrument_id")
    private Instrument instrument;
    
    @ManyToOne
    @JoinColumn(name="type_id")
    private Type type;

    public Note() {
        super();
    }

    public Note(String note, Song song, Instrument instrument, Type type) {
        this.note = note;
        this.song = song;
        this.instrument = instrument;
        this.type = type;
    }

    public Long getNote_id() {
        return note_id;
    }

    public void setNote_id(Long note_id) {
        this.note_id = note_id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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

    @Override
    public String toString() {
        return "Note [note_id=" + note_id + ", note=" + note + "]";
    } 

}
