package org.example.ecommercespring.gateway;

import org.example.ecommercespring.dto.UserDTO;

import java.io.IOException;
import java.util.List;

public interface IUserGateway {

    List<UserDTO> getUsers() throws IOException;
}
