package com.istic.casanova.repository;

import com.istic.casanova.model.PlusValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlusValueRepository extends JpaRepository<PlusValue, Long> {

}
