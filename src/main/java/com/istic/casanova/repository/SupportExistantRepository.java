package com.istic.casanova.repository;

import com.istic.casanova.model.SupportExistant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupportExistantRepository extends JpaRepository<SupportExistant,Long> {
}
