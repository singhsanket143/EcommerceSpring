package org.example.ecommercespring.services;

import org.example.ecommercespring.dto.UserDTO;

import java.io.IOException;
import java.util.List;

public interface IUserService {

    List<UserDTO> getAllUsers() throws IOException;
}
