package com.istic.casanova.repository;

import com.istic.casanova.model.ModeReglement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeReglementRepository extends JpaRepository<ModeReglement,Long> {
}
