package com.istic.casanova.service;

import com.istic.casanova.model.Dossier;
import com.istic.casanova.model.FileDB;
import com.istic.casanova.repository.FileDBRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;
import java.util.stream.Stream;

@Service
public class FileStorageService {

    @Autowired
    private FileDBRepository fileDBRepository;

    /**
     * Enregistrement fichier
     * @param file
     * @param dossier
     * @param categorie
     * @return
     * @throws IOException
     */
    public FileDB store(MultipartFile file, Dossier dossier, String categorie) throws IOException {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        FileDB fileDB = new FileDB(fileName, file.getContentType(), file.getBytes());
        fileDB.setCategorie(categorie);
        fileDB.setDossier(dossier);
        dossier.addFile(fileDB);
        return fileDBRepository.save(fileDB);
    }

    public FileDB getFile(Long id) {
        if (fileDBRepository.findById(id).isPresent()) {
            return fileDBRepository.findById(id).get();
        } else {
            return null;
        }
    }

    public Stream<FileDB> getAllFiles() {
        return fileDBRepository.findAll().stream();
    }

    public Stream<FileDB> getAllFilesFromDossier(Long id) throws NotFoundException {
        return fileDBRepository.findFilesByIdDossier(id).stream();
    }

    public FileDB getFileFromDossier(Long dossier_id, Long file_id) {
        return fileDBRepository.findFileByIdDossier(dossier_id, file_id).get(0);
    }


}
