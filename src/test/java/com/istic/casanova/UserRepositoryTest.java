package com.istic.casanova;

import com.istic.casanova.model.User;
import com.istic.casanova.repository.UserRepository;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    User user1;
    User user2;

    @BeforeEach
    public void setup() {
        user1 = new User();
        user1.setEmail("user1@user1.com");
        user1.setPassword("passwordUser1");
        user1.setNom("u1");
        user1.setPrenom("u1");

        user2 = new User();
        user2.setEmail("user2@user2.com");
        user2.setPassword("passwordUser2");
        user2.setNom("u2");
        user2.setPrenom("u2");
    }

    @Test
    public void testCreateUser() {

        User savedUser = userRepository.save(user1);
        User existUser = entityManager.find(User.class, savedUser.getId());

        assert (savedUser.getEmail()).equals(existUser.getEmail());
    }

    @Test
    public void testCreateUserSameEmail() {

        User savedUser1 = userRepository.save(user1);
        User savedUser2 = userRepository.save(user2);

        User existUser1 = entityManager.find(User.class, savedUser1.getId());
        User existUser2 = entityManager.find(User.class, savedUser2.getId());

        assert (user1.getEmail()).equals(existUser1.getEmail());
        assert !(savedUser2.getEmail().equals(existUser1.getEmail()));
    }


}
