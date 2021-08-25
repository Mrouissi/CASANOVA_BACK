package com.istic.casanova.repository;

import com.istic.casanova.model.Client;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ClientRepository extends AbstractRepository<Client>{

    List<Client> findByCommercialId(Long commercialId);
}

