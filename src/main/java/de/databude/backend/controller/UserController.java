package de.databude.backend.controller;

import java.util.List;

import de.databude.backend.dto.UserDTO;

public interface UserController {

    List<UserDTO> getAllUsers();

    UserDTO getMethodName(Long userId);

}