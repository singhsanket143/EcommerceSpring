package org.example.ecommercespring.services;

import org.example.ecommercespring.dto.UserDTO;
import java.io.IOException;

public interface IUserService {
    UserDTO getUser(int id) throws IOException;
}
