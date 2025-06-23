package org.example.ecommercespring.controllers;

import org.example.ecommercespring.dto.UserDTO;
import org.example.ecommercespring.services.FakeStoreUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UsersController {

    private final FakeStoreUserService fakeStoreUserService;

    public UsersController(FakeStoreUserService fakeStoreUserService) {
        this.fakeStoreUserService = fakeStoreUserService;
    }

    @GetMapping("/users")
    public List<UserDTO> getUsers() throws IOException {
        return fakeStoreUserService.getAllUsers();
    }
}
