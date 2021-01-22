package com.istic.casanova.repository;

import com.istic.casanova.model.Client;
import com.istic.casanova.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Client, Long>{
    Optional<User> findByUserName(String userName);
}
