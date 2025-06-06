package de.databude.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.databude.backend.dto.UserDTO;
import de.databude.backend.service.UserService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/users")
public class UserControllerImpl {
    
    UserService userService;

    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    } 

    @GetMapping("/")
    public List<UserDTO> getAllUsers() {
        return this.userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public UserDTO getMethodName(@PathVariable Long userId) {
        return this.userService.getUserById(userId);
    }
    
    

}
