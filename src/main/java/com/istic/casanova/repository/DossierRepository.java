package com.istic.casanova.repository;

import com.istic.casanova.model.Dossier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DossierRepository extends JpaRepository<Dossier, Long>{
    @Query("SELECT d FROM Dossier d WHERE d.client.id = ?1")
    List<Dossier> findDossierByIdClient(Long client_id);
}
