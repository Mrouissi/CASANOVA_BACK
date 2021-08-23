package com.istic.casanova.repository;

import com.istic.casanova.model.EntiteVente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntiteVenteRepository extends JpaRepository<EntiteVente,Long> {
}
