package com.istic.casanova.restcontroller;

import com.istic.casanova.model.Chantier;
import com.istic.casanova.model.Client;
import com.istic.casanova.model.Dossier;
import com.istic.casanova.model.FileDB;
import com.istic.casanova.repository.ChantierRepository;
import com.istic.casanova.repository.ClientRepository;
import com.istic.casanova.repository.DossierRepository;
import com.istic.casanova.service.EmailSenderService;
import com.istic.casanova.service.FileStorageService;
import com.istic.casanova.utils.message.ResponseFile;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class DossierController {

    @Autowired
    private DossierRepository dossierRepository;

    @Autowired
    private ChantierRepository chantierRepository;

    @Autowired
    private FileStorageService storageService;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private EmailSenderService emailSenderService;

    @PostMapping("/dossiers/{id}/upload")
    public ResponseEntity<String> uploadFiles(@PathVariable Long id,
                                              @RequestParam("category") String category,
                                              @RequestParam("file") MultipartFile file
                                             ) throws NotFoundException {
        String message = "";

        /*Optional<Client> client = clientRepository.findById(id);
        System.out.println("test client : "+client);*/
        Optional<Dossier> dossier = dossierRepository.findById(id);
        if(dossier.isEmpty()) {
            throw new NotFoundException("Dossier not found, id : " + id);
        }
        try {
            FileDB fileDB = storageService.store(file, dossier.get(), category);
            dossier.get().addFile(fileDB);
            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(message);

        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
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

    @GetMapping("/dossiers/{id}/chantiers")
    public List<Chantier> getListChantier(@PathVariable Long id) throws NotFoundException {
        Optional<Dossier> dossier = dossierRepository.findById(id);
        if(dossier.isEmpty()) {
            throw new NotFoundException("Dossier not found, id : " + id);
        }
        return chantierRepository.findChantiersByIdDossier(dossier.get().getId());
    }

    @GetMapping("/dossiers/{id}")
    public Dossier getDossier(@PathVariable Long id) throws NotFoundException {
        Optional<Dossier> dossier = dossierRepository.findById(id);
        if(dossier.isEmpty()) {
            throw new NotFoundException("Dossier not found, id : " + id);
        }
        return dossier.get();
    }

    @PostMapping("/dossiers/{id}")
    public ResponseEntity<Object> createDossier(@RequestBody Dossier dossier) {
        Client client = null;
        try {
            client = dossier.getClient();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(client == null) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Empty client");
        } else {
            Dossier savedDossier = dossierRepository.save(dossier);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("Dossier created");
        }
    }


    @PutMapping("/dossiers/{id}/{idClient}")
    public ResponseEntity<Object> updateDossier(@RequestBody Dossier dossier, @PathVariable long id ,
                                                @PathVariable long idClient) {
        Optional<Dossier> dossierOptional = dossierRepository.findById(id);
        Optional<Client> client = clientRepository.findById(idClient);
        if (dossierOptional.isEmpty())
            return ResponseEntity.notFound().build();
        dossier.setId(id);
        dossier.setClient(client.get());
        dossierRepository.save(dossier);
        return ResponseEntity.noContent().build();
    }

}