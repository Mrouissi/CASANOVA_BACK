package com.istic.casanova.repository;

import com.istic.casanova.model.BonDeCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BonDeCommandeRepository extends JpaRepository<BonDeCommande,Long> {
}
