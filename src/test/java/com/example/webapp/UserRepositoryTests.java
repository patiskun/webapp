package com.example.webapp;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.webapp.entity.User;
import com.example.webapp.repository.UserRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

    @Autowired
    private UserRepository repo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUser(){
        User user = new User();
        user.setEmail("ravikumar@mail.ry");
        user.setPassword("ravi2002");
        user.setFirstname("ravi");
        user.setLastname("Kumar");

        User savedUser = repo.save(user);

        User existUser = entityManager.find(User.class,savedUser.getId());
        assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
    }

}
