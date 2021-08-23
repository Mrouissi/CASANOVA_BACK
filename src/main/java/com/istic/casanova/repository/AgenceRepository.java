package com.istic.casanova.repository;

import com.istic.casanova.model.Agence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgenceRepository extends JpaRepository<Agence,Long> {

}
