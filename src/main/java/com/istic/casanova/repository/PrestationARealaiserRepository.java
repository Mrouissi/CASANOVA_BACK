package com.istic.casanova.repository;

import com.istic.casanova.model.PrestationARealiser;
import com.istic.casanova.model.SupportExistant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrestationARealaiserRepository extends JpaRepository<PrestationARealiser,Long> {
    @Query("select p.supportExistantList from PrestationARealiser p where p.id=?1")
    List<SupportExistant> findSupportExistantByPrestationId(Long prestation_id);
}
