package com.istic.casanova.repository;

import com.istic.casanova.model.Commercial;

import javax.transaction.Transactional;

@Transactional
public interface CommercialRepository extends AbstractRepository<Commercial>{
    Boolean existsByEmail(String email);

}
