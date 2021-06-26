package com.istic.casanova.repository;

import com.istic.casanova.model.User;
import javax.transaction.Transactional;

@Transactional
public interface UserRepository extends AbstractRepository<User>{
    public User findByEmailAndPassword(String email, String password);
}