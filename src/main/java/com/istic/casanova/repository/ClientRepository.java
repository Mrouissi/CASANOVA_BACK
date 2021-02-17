package com.istic.casanova.repository;

import com.istic.casanova.model.Client;

import javax.transaction.Transactional;

@Transactional
public interface ClientRepository extends AbstractRepository<Client>{
}
