package org.example.ecommercespring.services;

import org.example.ecommercespring.dto.UserDTO;
import org.example.ecommercespring.gateway.IUserGateway;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FakeStoreUserService implements IUserService {

    private final IUserGateway userGateway;

    public FakeStoreUserService(IUserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public List<UserDTO> getAllUsers() throws IOException {
        return userGateway.getUsers();
    }
}
