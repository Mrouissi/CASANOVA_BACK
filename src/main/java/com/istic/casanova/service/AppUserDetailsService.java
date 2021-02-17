package com.istic.casanova.service;

import com.istic.casanova.model.User;
import com.istic.casanova.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User : " + username + " not found");
        }
        return new UserDetailsImpl(user.get());
    }

    @Transactional
    public boolean isEmailUse(String email){
        boolean emailInDb = true;
        if (userRepository.findByEmail(email).isEmpty()) emailInDb = false;
        return emailInDb;
    }

}
