package com.istic.casanova.restcontroller;

import com.istic.casanova.model.Dossier;
import com.istic.casanova.model.FileDB;
import com.istic.casanova.repository.DossierRepository;
import com.istic.casanova.service.FileStorageService;
import com.istic.casanova.utils.message.ResponseFile;
import com.istic.casanova.utils.message.ResponseMessage;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class DossierController {

    @Autowired
    private DossierRepository dossierRepository;

    @Autowired
    private FileStorageService storageService;

    @PostMapping("/dossiers/{id}/upload")
    public ResponseEntity<String> uploadFiles(@PathVariable Long id,
                                              @RequestParam("files") MultipartFile[] files,
                                              @RequestParam("categories") String[] categories) throws NotFoundException {
        String message = "";
        Optional<Dossier> dossier = dossierRepository.findById(id);
        if(dossier.isEmpty()) {
            throw new NotFoundException("Dossier not found, id : " + id);
        }
        try {
            List<String> fileNames = new ArrayList<>();
            int i = 0;
            for(MultipartFile file: files) {
                FileDB fileDB = storageService.store(file, dossier.get(), categories[i]);
                fileNames.add(file.getOriginalFilename());
                i++;
            }
            message = "Uploaded the files successfully: " + fileNames;
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            message = "Could not upload the files ";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }
    }

    @GetMapping("/dossiers/{id}/files")
    public ResponseEntity<List<ResponseFile>> getListFiles(@PathVariable Long id) throws NotFoundException {

        List<ResponseFile> files = storageService.getAllFilesFromDossier(id).map(dbFile -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/files/")
                    .path(dbFile.getId().toString())
                    .toUriString();

            return new ResponseFile(
                    dbFile.getNom(),
                    fileDownloadUri,
                    dbFile.getType(),
                    dbFile.getData().length);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(files);
    }

    @GetMapping("/dossiers/{dossier_id}/files/{file_id}")
    public ResponseEntity<byte[]> getFile(@PathVariable Long dossier_id, @PathVariable Long file_id) throws NotFoundException {
        FileDB fileDB = storageService.getFileFromDossier(dossier_id, file_id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getNom() + "\"")
                .body(fileDB.getData());
    }
}