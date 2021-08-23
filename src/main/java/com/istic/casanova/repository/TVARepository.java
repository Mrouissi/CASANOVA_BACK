package com.istic.casanova.repository;

import com.istic.casanova.model.TVA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TVARepository extends JpaRepository<TVA,Long> {
}
