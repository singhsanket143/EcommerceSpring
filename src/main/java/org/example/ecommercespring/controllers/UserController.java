package org.example.ecommercespring.controllers;

import org.example.ecommercespring.dto.UserDTO;
import org.example.ecommercespring.services.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable int id) throws IOException {
        //return "ID " + id;
        return this.userService.getUser(id);
    }
}
