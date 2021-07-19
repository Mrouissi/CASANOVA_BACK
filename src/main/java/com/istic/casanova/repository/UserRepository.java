package com.istic.casanova.repository;

import com.istic.casanova.model.User;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
public interface UserRepository extends AbstractRepository<User>{

    Optional<User> findByUsername(String username);

    Boolean existsByEmail(String email);
}
