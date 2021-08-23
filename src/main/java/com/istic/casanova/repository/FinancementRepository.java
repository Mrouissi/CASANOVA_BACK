package com.istic.casanova.repository;

import com.istic.casanova.model.Financement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinancementRepository extends JpaRepository<Financement,Long> {
}
