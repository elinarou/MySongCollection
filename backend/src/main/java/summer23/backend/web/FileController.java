package summer23.backend.web;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import summer23.backend.domain.FileModel;
import summer23.backend.domain.FileModelRepository;
import summer23.backend.domain.Note;
import summer23.backend.domain.NoteRepository;


@Controller
public class FileController {

	@Autowired
	private FileModelRepository fileRepository; 	

    @Autowired
	private NoteRepository noteRepository; 

    @Value("${upload.path}")
    private String uploadFolder;
    
    @GetMapping("/upload")
    public String note() {
        return "upload";
    }

    @PostMapping("/savefile")
    public String fileUpload(@RequestParam("file") MultipartFile file, Model model, Note note) {
        if (file.isEmpty()) {
        	model.addAttribute("msg", "Upload failed");
            return "uploadstatus";
        }
        try {
            FileModel fileModel = new FileModel(file.getOriginalFilename(), file.getContentType(), note, file.getBytes());
            fileRepository.save(fileModel);
    
            return "redirect:/sheetmusiclist";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "uploadstatus";
    }
    
    @GetMapping("/files")
    public String fileList(Model model) {
    	model.addAttribute("files", fileRepository.findAll());  	
    	return "filelist";
    }
    
	@GetMapping("/file/{id}")
	public ResponseEntity<byte[]> getFile(@PathVariable Long id) {
		Optional<FileModel> fileOptional = fileRepository.findById(id);
		
		if(fileOptional.isPresent()) {
			FileModel file = fileOptional.get();
			return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFileName() + "\"")
					.body(file.getFile());	
		}
		
		return ResponseEntity.status(404).body(null);
	}    
    
}