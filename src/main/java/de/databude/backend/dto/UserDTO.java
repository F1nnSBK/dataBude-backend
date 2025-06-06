package de.databude.backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;
    @NotNull(message = "Username cannot be null")
    private String username;

    
    private String profileUrl;

    @NotNull(message = "Email cannot be null")
    @Email(message = "Email should be valid")
    private String email;
}
