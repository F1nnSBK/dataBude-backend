package de.databude.backend;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import de.databude.backend.model.User;
import de.databude.backend.service.UserService;

@Component
public class ManualTestBean {

    private final UserService userService;

    public ManualTestBean(UserService userService) {
        this.userService = userService;
        userService.testUser();
    }

    @EventListener(classes = {ApplicationStartedEvent.class})
    public void testUser() {
        User user = userService.getUserById(1L);
        if (user != null) {
            System.out.println("User found: " + user.getUsername());
        } else {
            System.out.println("User not found.");
        }
    
    }
}
