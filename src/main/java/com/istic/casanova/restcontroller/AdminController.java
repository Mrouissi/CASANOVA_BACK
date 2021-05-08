package com.istic.casanova.restcontroller;

import com.istic.casanova.model.Admin;
import com.istic.casanova.model.Admin;
import com.istic.casanova.model.User;
import com.istic.casanova.repository.AdminRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;

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

    @PostMapping("/admins")
    public ResponseEntity<String> createAdmin(@RequestBody Admin admin) {
        Optional<Admin> testAdmin = adminRepository.findByEmail(admin.getEmail());
        if (testAdmin.isEmpty()) {
            User savedUser = adminRepository.save(admin);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("User created");
        } else {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body("Email already use");
        }
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
