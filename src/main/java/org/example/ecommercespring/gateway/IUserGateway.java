package org.example.ecommercespring.gateway;

import org.example.ecommercespring.dto.UserDTO;
import java.io.IOException;

public interface IUserGateway {
    UserDTO getUser(int id) throws IOException;
}
