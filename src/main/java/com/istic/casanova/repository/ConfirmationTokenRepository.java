package com.istic.casanova.repository;

import com.istic.casanova.model.ConfirmationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, String> {

    ConfirmationToken findByConfirmationToken(String confirmationToken);

}
