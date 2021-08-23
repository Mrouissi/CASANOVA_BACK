package com.istic.casanova.repository;

import com.istic.casanova.model.ElementARenover;
import com.istic.casanova.model.PrestationARealiser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElementARenoverRepository extends JpaRepository<ElementARenover,Long> {
    @Query("select e.prestationARealiserList from ElementARenover e where e.id= ?1")
    List<PrestationARealiser> findPrestationARealiserByElementId(Long element_Id);
}
