package com.istic.casanova.repository;

import com.istic.casanova.model.OrigineContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrigineContactRepository extends JpaRepository<OrigineContact,Long> {
}
