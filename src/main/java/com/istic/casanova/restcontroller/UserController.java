package com.istic.casanova.restcontroller;

import com.istic.casanova.model.User;
import com.istic.casanova.repository.UserRepository;
import javassist.NotFoundException;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /**
     * Login
     * @param user
     * @return info user
     * @throws JSONException
     */
    @RequestMapping("/login")
    public User login(@RequestBody String user) throws JSONException {
        User user1 = new User();
        JSONObject json = new JSONObject(user);
        if (userRepository.findByEmail(json.getString("username")).isPresent()) {
            user1 = userRepository.findByEmail(json.getString("username")).get();
            boolean pass = BCrypt.checkpw(json.getString("password"), user1.getPassword());
            if (!pass) {
                return new User();
            } else {
                user1.setPassword(null);
                return user1;
            }
        } else {
            return user1;
        }
    }

    /**
     *
     * @return liste users
     */
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     *
     * @param id
     * @return user
     * @throws NotFoundException
     */
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id) throws NotFoundException {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()) {
            throw new NotFoundException("User not found, id : "+id);
        }
        return user.get();
    }

    /**
     *
     * @param email
     * @return user
     * @throws NotFoundException
     */
    @GetMapping("/users/mail/{email}")
    public User getUserByEmail(@PathVariable String email) throws NotFoundException {
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isEmpty()) {
            throw new NotFoundException("User not found, email : "+email);
        }
        return user.get();
    }

    /**
     * Supprime user
     * @param id
     */
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable long id) {
        userRepository.deleteById(id);
    }

    @PostMapping("/users")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        Optional<User> testUser = userRepository.findByEmail(user.getEmail());
        if (testUser.isEmpty()) {
            User savedUser = userRepository.save(user);
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
     * Mise a jour User
     * @param user
     * @param id
     * @return reponse
     */
    @PutMapping("/users/{id}")
    public ResponseEntity<Object> updateUser(@RequestBody User user, @PathVariable long id) {

        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty())
            return ResponseEntity.notFound().build();
        user.setId(id);
        userRepository.save(user);
        return ResponseEntity.noContent().build();
    }

}
