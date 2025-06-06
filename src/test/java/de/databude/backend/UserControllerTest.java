package de.databude.backend;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import de.databude.backend.controller.UserController;
import de.databude.backend.dto.UserDTO;
import de.databude.backend.service.UserService;

@WebMvcTest(controllers = UserController.class)
@AutoConfigureMockMvc(addFilters = false)
public class UserControllerTest {

  @MockBean
  UserService userService;

  @Autowired
  ObjectMapper objectMapper;

  @Autowired
  MockMvc mockMvc;

  UserDTO user1;
  UserDTO user2;
  List<UserDTO> users;

  private final String controllerPath = "/api/users";

  @BeforeEach
  void setup() {
    user1 = new UserDTO(
        1L, 
        "user1", 
        "profile_pic.png", 
        "email@email.com");
    user2 = new UserDTO(
        2L, 
        "user2", 
        "profile_pic.png", 
        "email@email.com");

    users = List.of(user1, user2);
  }
  
  @Test
  void shouldSuccessfullyReturnAllUsers() throws Exception {
	when(userService.getAllUsers()).thenReturn(users);
	this.mockMvc.perform(get(controllerPath + "/"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.*", hasSize(2)))
		.andExpect(jsonPath("$[0].id", is(users.get(0).getId().intValue())))

		.andExpect(jsonPath("$[1].id", is(users.get(1).getId().intValue())));
	verify(userService).getAllUsers();
  }


}
