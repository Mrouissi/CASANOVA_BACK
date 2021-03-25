package com.istic.casanova.restcontroller;

import com.istic.casanova.model.Commercial;
import com.istic.casanova.model.User;
import com.istic.casanova.repository.CommercialRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CommercialController {

    @Autowired
    private CommercialRepository commercialRepository;

    @GetMapping("/commercials")
    public List<Commercial> getAllCommercials() {
        return commercialRepository.findAll();
    }

    @GetMapping("/commercials/{id}")
    public Commercial getCommercialsById(@PathVariable Long id) throws NotFoundException {
        Optional<Commercial> commercial = commercialRepository.findById(id);
        if(commercial.isEmpty()) {
            throw new NotFoundException("Commercial not found, id : "+id);
        }
        return commercial.get();
    }

    @GetMapping("/commercials/mail/{email}")
    public Commercial getCommercialByEmail(@PathVariable String email) throws NotFoundException {
        Optional<Commercial> commercial = commercialRepository.findByEmail(email);
        if(commercial.isEmpty()) {
            throw new NotFoundException("Commercial not found, email : "+email);
        }
        return commercial.get();
    }

    @DeleteMapping("/commercials/{id}")
    public void deleteCommercial(@PathVariable long id) {
        commercialRepository.deleteById(id);
    }

    @PostMapping("/commercials")
    public ResponseEntity<String> createCommercial(@RequestBody Commercial commercial) {
        Optional<Commercial> testCommercial = commercialRepository.findByEmail(commercial.getEmail());
        if (testCommercial.isEmpty()) {
            User savedUser = commercialRepository.save(commercial);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("User created");
        } else {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body("Email already use");
        }    }

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
