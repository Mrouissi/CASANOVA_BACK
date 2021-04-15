package com.istic.casanova.service;

import com.istic.casanova.model.Client;
import com.istic.casanova.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClientServices {

        @Autowired
        private ClientRepository repo;

        public List<Client> listAll() {
            return repo.findAll(Sort.by("email").ascending());
        }
}
