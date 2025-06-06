package de.databude.backend.service;

import java.util.List;

import de.databude.backend.dto.UserDTO;

public interface UserService {

    void testUser();

    UserDTO getUserById(long id);

    List<UserDTO> getAllUsers();

}