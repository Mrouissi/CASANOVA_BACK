package com.istic.casanova.repository;

import com.istic.casanova.model.OrganismeFinancement;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganismeFinancementRepository extends JpaRepositoryImplementation<OrganismeFinancement,Long> {
}
