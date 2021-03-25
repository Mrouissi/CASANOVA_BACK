package com.istic.casanova.repository;

import com.istic.casanova.model.Dossier;
import com.istic.casanova.model.FileDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileDBRepository extends JpaRepository<FileDB, Long> {
    @Query("SELECT f FROM FileDB f WHERE f.dossier.id = ?1")
    List<FileDB> findFilesByIdDossier(Long dossier_id);

    @Query("SELECT f FROM FileDB f WHERE f.dossier.id = ?1 and f.id = ?2")
    List<FileDB> findFileByIdDossier(Long dossier_id, Long file_id);
}