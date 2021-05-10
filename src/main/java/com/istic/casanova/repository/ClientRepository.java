package com.istic.casanova.repository;

import com.istic.casanova.model.Client;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ClientRepository extends AbstractRepository<Client>{
}
