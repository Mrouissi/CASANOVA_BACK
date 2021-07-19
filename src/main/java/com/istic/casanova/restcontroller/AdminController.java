package com.istic.casanova.restcontroller;

import com.istic.casanova.model.Admin;
import com.istic.casanova.model.ERole;
import com.istic.casanova.model.Role;
import com.istic.casanova.repository.AdminRepository;
import com.istic.casanova.repository.RoleRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    /**
     * @return la liste des administrateurs
     */
    @GetMapping("/admins")
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    /**
     *
     * @param id
     * @return un administrateur correspondant à l'id
     * @throws NotFoundException
     */
    @GetMapping("/admins/{id}")
    public Admin getAdminsById(@PathVariable Long id) throws NotFoundException {
        Optional<Admin> admin = adminRepository.findById(id);
        if(admin.isEmpty()) {
            throw new NotFoundException("Admin not found, id : "+id);
        }
        return admin.get();
    }

    /**
     *
     * @param email
     * @return un administrateur correspondant à l'email
     * @throws NotFoundException
     */
    @GetMapping("/admins/mail/{email}")
    public Admin getAdminByEmail(@PathVariable String email) throws NotFoundException {
        Optional<Admin> admin = adminRepository.findByEmail(email);
        if(admin.isEmpty()) {
            throw new NotFoundException("Admin not found, email : "+email);
        }
        return admin.get();
    }

    /**
     * Supprime un administrateur avec l'id en paramètre
     * @param id
     */
    @DeleteMapping("/admins/{id}")
    public void deleteAdmin(@PathVariable long id) {
        adminRepository.deleteById(id);
    }

    /**
     *  Créer un administrateur
     * @param admin
     * @return
     * @throws Exception
     */
    @PostMapping("/registerAdmin")
    public Admin createAdmin(@RequestBody Admin admin) throws Exception{
        String tempEmail = admin.getEmail();
        if (tempEmail != null && !"".equals(tempEmail)) {
            Optional<Admin> testAdmin = adminRepository.findByEmail(tempEmail);
            if (!testAdmin.isEmpty()) {
                throw new Exception("l'administrateur " + tempEmail + " existe déjà.");
            }
        }
        Admin savedAdmin = new Admin();
        Set<Role> roles = new HashSet<>();
        Optional<Role> adminRole = roleRepository.findByName(ERole.ROLE_ADMIN);
        roles.add(adminRole.get());
        admin.setRoles(roles);
        admin.setIsEnabled(true);
        admin.setPassword(encoder.encode(admin.getPassword()));
        savedAdmin = adminRepository.save(admin);
        return savedAdmin;
    }

    /**
     * Modification d'un administrateur
     * @param admin
     * @param id
     * @return
     */
    @PutMapping("/admins/{id}")
    public ResponseEntity<Object> updateAdmin(@RequestBody Admin admin, @PathVariable long id) {
        Optional<Admin> adminOptional = adminRepository.findById(id);
        if (adminOptional.isEmpty())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Aucun admin ne correspond à l'id");
        admin.setId(id);
        adminRepository.save(admin);
        return ResponseEntity.status(200).body("Update Admin OK");
    }
}
