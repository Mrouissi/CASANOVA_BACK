package com.istic.casanova.restcontroller;

import com.istic.casanova.model.Commercial;
import com.istic.casanova.model.ERole;
import com.istic.casanova.model.Role;
import com.istic.casanova.repository.CommercialRepository;
import com.istic.casanova.repository.RoleRepository;
import com.istic.casanova.repository.UserRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class CommercialController {

    @Autowired
    private CommercialRepository commercialRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    /**
     * @return liste commerciaux
     */
    @GetMapping("/commercials")
    public List<Commercial> getAllCommercials() {

        return commercialRepository.findAll();
    }

    /**
     * @param id
     * @return commercial
     * @throws NotFoundException
     */
    @GetMapping("/commercials/{id}")
    public Commercial getCommercialsById(@PathVariable Long id) throws NotFoundException {
        Optional<Commercial> commercial = commercialRepository.findById(id);
        if (commercial.isEmpty()) {
            throw new NotFoundException("Commercial not found, id : " + id);
        }
        return commercial.get();
    }

    /**
     * @param email
     * @return commercial
     * @throws NotFoundException
     */
    @GetMapping("/commercials/mail/{email}")
    public Commercial getCommercialByEmail(@PathVariable String email) throws NotFoundException {
        Optional<Commercial> commercial = commercialRepository.findByEmail(email);
        if (commercial.isEmpty()) {
            throw new NotFoundException("Commercial not found, email : " + email);
        }
        return commercial.get();
    }

    /**
     * Supprime commercial
     *
     * @param id
     */
    @DeleteMapping("/commercials/{id}")
    public void deleteCommercial(@PathVariable long id) {
        commercialRepository.deleteById(id);
    }

    /**
     * Création commercial
     *
     * @param commercial
     * @return commercial
     */
    @PostMapping("/commercials")
    public Commercial createCommercial(@RequestBody Commercial commercial) throws Exception {
        String tempEmail = commercial.getEmail();
        if (tempEmail != null && !"".equals(tempEmail)) {
            Optional<Commercial> testCommercial = commercialRepository.findByEmail(tempEmail);
            if (!testCommercial.isEmpty()) {
                throw new Exception("le commercial avec " + tempEmail + " existe déjà.");
            }
        }
        Commercial savedCommercial = new Commercial();
        Set<Role> roles = new HashSet<>();
        Optional<Role> commercialRole = roleRepository.findByName(ERole.ROLE_COMMERCIAL);
        roles.add(commercialRole.get());
        commercial.setRoles(roles);
        commercial.setIsEnabled(true);
        commercial.setPassword(encoder.encode(commercial.getPassword()));
        savedCommercial = commercialRepository.save(commercial);

        return savedCommercial;

    }

    /**
     * Mise à jour commercial
     *
     * @param commercial
     * @param id
     * @return
     */
    @PutMapping("/commercials/{id}")
    public ResponseEntity<Object> updateCommercial(@RequestBody Commercial commercial, @PathVariable long id) {
        Optional<Commercial> commercialOptional = commercialRepository.findById(id);
        if (commercialOptional.isEmpty())
            return ResponseEntity.notFound().build();
        commercial.setId(id);
        commercialRepository.save(commercial);
        return ResponseEntity.noContent().build();
    }
}


