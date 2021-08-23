package com.istic.casanova.repository;

import com.istic.casanova.model.Comptant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComptantRepository extends JpaRepository<Comptant,Long> {
}
