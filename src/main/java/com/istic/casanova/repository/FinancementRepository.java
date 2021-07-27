package com.istic.casanova.repository;

import com.istic.casanova.model.Financement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancementRepository extends JpaRepository<Financement,Long> {
}
