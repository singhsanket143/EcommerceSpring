package org.example.ecommercespring.services;

import org.example.ecommercespring.dto.UserDTO;
import org.example.ecommercespring.gateway.IUserGateway;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class FakeStoreUserService implements IUserService {
    private final IUserGateway userGateway;

    public FakeStoreUserService(IUserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public UserDTO getUser(int id) throws IOException {
        return this.userGateway.getUser(id);
    }
}
