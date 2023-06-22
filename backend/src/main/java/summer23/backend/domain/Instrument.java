package summer23.backend.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Instrument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long instrument_id;
    private String instrument;

    public Instrument() {
        super();
    }

    public Instrument(String instrument) {
        this.instrument = instrument;
    }

    public Long getInstrument_id() {
        return instrument_id;
    }

    public void setInstrument_id(Long instrument_id) {
        this.instrument_id = instrument_id;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    @Override
    public String toString() {
        return "Instrument [instrument_id=" + instrument_id + ", instrument=" + instrument + "]";
    }

}
