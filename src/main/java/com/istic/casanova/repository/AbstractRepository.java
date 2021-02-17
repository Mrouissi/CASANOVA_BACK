package com.istic.casanova.repository;

import com.istic.casanova.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface AbstractRepository<T extends User> extends JpaRepository<T, Long>{
    @Query("SELECT u FROM #{#entityName} u WHERE u.email = ?1")
    Optional<T> findByEmail(String email);
}
