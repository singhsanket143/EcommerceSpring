package org.example.ecommercespring.gateway;
import org.example.ecommercespring.dto.FakeStoreAllUsersResponseDTO;
import org.example.ecommercespring.dto.UserDTO;
import org.example.ecommercespring.gateway.api.FakeStoreUserApi;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class FakeStoreUsersGateway implements IUserGateway{

    private final FakeStoreUserApi fakeStoreUserApi;

    public FakeStoreUsersGateway(FakeStoreUserApi fakeStoreUserApi) {
        this.fakeStoreUserApi = fakeStoreUserApi;
    }

    @Override
    public List<UserDTO> getUsers() throws IOException {
        FakeStoreAllUsersResponseDTO response = fakeStoreUserApi.findAllUsers();

        if(response == null || response.getUsers() == null)
            throw new IOException("Failed to fetch users from FakeStore API");

        return response.getUsers();
    }
}
