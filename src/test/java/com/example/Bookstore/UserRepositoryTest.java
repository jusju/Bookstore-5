package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.Bookstore.domain.User;
import com.example.Bookstore.domain.UserRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTest {
	@Autowired
    private UserRepository urepository;

    @Test
    public void initialUsersAreReturned() {
        List<User> users = urepository.findByRole("ADMIN");
        
        assertThat(users).hasSize(1);
        assertThat(users.get(0).getUsername()).isEqualTo("admin");
    }
    
    @Test
    public void createNewStudent() {
    	User user = new User("testuser", "TESTUSER", "$2a$10$RoSelM03e2GES7MUbrUAtuq9jNVlg0Go02OeS7tXOU.D7i68V0TN.");
    	urepository.save(user);
    	assertThat(user.getId()).isNotNull();
    }    
}
