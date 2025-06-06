package de.databude.backend.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import de.databude.backend.dto.UserDTO;
import de.databude.backend.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO userToUserDTO(User user);
    List<UserDTO> usersToUserDTOs(List<User> users);

    User userDTOToUser(UserDTO userDTO);
    List<User> userDTOsToUsers(List<UserDTO> userDTOs);
}