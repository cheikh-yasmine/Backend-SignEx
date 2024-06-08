package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import project.models.FileUploadEntity;
import project.service.FileUploadService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/files")
public class FileUploadController {

    @Autowired  // Inject the FileUploadService dependency
    private final FileUploadService fileUploadService;


    public FileUploadController(FileUploadService fileUploadService) {
        this.fileUploadService = fileUploadService;

    }

    @PostMapping
    public ResponseEntity<FileUploadEntity> uploadFile(

            @RequestParam("description") String description,
            @RequestParam("file") MultipartFile file) throws IOException {
        FileUploadEntity theFile = fileUploadService.uploadFile(description, file);
        return new ResponseEntity<>(theFile, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFileById(@PathVariable Long id) {
        try {
            String message = fileUploadService.deleteFileById(id);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (FileNotFoundException e) {
            // Handle file not found case (log the exception)
            System.err.println("Error deleting file: File not found with ID " + id);
            return new ResponseEntity<>("File with ID " + id + " not found", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            // Handle other potential exceptions (log the exception)
            System.err.println("Error deleting file: " + e.getMessage());
            return new ResponseEntity<>("An error occurred while deleting the file", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/getAllFiles")
    public ResponseEntity<List<FileUploadEntity>> getAllFiles() {
        List<FileUploadEntity> files = fileUploadService.getAllFiles();
        return new ResponseEntity<>(files, HttpStatus.OK);
    }
}


//@GetMapping("/download/{id}")
//public ResponseEntity<byte[]> downloadFileById(@PathVariable Long id) throws IOException {
//    FileUploadEntity file = fileUploadService.getFileById(id);
//
//    if (file == null) {
//        return ResponseEntity.notFound().build();
//    }
//
//   else {
//        return ResponseEntity.ok()
//                .contentType(MediaType.parseMediaType(file.getType()))
//                .contentLength(file.getFile().length)
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
//                .body(file.getFile());
//    }

