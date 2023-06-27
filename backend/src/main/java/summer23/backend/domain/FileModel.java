package summer23.backend.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

@Entity
public class FileModel {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String fileName, mimeType, base64str;

	@ManyToOne
	private Note note;

	@Lob
	private byte[] file;
	
	public FileModel() {}
	
	public FileModel(String fileName, String mimeType, Note note, byte[] file) {
		this.fileName = fileName;
		this.mimeType = mimeType;
		this.note = note;
		this.file = file;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public Note getNote() {
		return note;
	}

	public void setNote(Note note) {
		this.note = note;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}


}