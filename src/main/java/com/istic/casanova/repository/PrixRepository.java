package com.istic.casanova.repository;

import com.istic.casanova.model.Prix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrixRepository extends JpaRepository<Prix,Long> {
}
