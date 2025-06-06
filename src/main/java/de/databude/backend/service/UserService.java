package de.databude.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import de.databude.backend.dto.UserDTO;
import de.databude.backend.mapper.UserMapper;
import de.databude.backend.model.User;
import de.databude.backend.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {

    @Value(value = "${config.emptyUserProfileUrl}")
    private String emptyUserProfileUrl;
    
    UserRepository userRepository;
    UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public void testUser() {
        UserDTO testUser = new UserDTO(1L, "testUser", "password", "email@email.com");
        try {
            userRepository.save(this.userMapper.userDTOToUser(testUser));
            log.info("User saved successfully: {}", testUser);
        } catch (Exception e) {
            log.error("Error saving user: {}", e.getMessage());
        }
        log.info("Testing user service...");
    }


    public UserDTO getUserById(long id) {
        return userRepository.findById(id)
            .map(user -> {
                if (user.getProfileUrl() == null) {
                    user.setProfileUrl(emptyUserProfileUrl);
                }
                return userMapper.userToUserDTO(user);
            })
            .orElseGet(() -> {
                log.error("No user found with id: {}", id);
                return null;
            });
    }


}
