package de.databude.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.databude.backend.model.User;
import de.databude.backend.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {
    
    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public void testUser() {
        User testUser = new User(1L, "testUser", "password", "email@email.com");
        try {
            userRepository.save(testUser);
            log.info("User saved successfully: {}", testUser);
        } catch (Exception e) {
            log.error("Error saving user: {}", e.getMessage());
        }
        log.info("Testing user service...");
    }

    public User getUserById(long id) {
        return userRepository.findById(id).orElse(null);
    }
}
