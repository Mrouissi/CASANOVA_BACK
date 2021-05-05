package com.istic.casanova.repository;

import com.istic.casanova.model.Dossier;
import com.istic.casanova.model.PeriodeAbs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeriodeAbsRepository extends JpaRepository<PeriodeAbs, Long>{
    @Query("SELECT p FROM PeriodeAbs p WHERE p.client.id = ?1")
    List<PeriodeAbs> findPeriodeAbsByIdClient(Long client_id);
}
