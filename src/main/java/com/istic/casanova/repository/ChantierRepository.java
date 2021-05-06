package com.istic.casanova.repository;

import com.istic.casanova.model.Chantier;
import com.istic.casanova.model.FileDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChantierRepository extends JpaRepository<Chantier, Long>{
    @Query("SELECT c FROM Chantier c WHERE c.dossier.id = ?1")
    List<Chantier> findChantiersByIdDossier(Long dossier_id);
}
