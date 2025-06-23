package org.example.ecommercespring.gateway.api;


import org.example.ecommercespring.dto.FakeStoreAllUsersResponseDTO;

import java.io.IOException;

public interface FakeStoreUserApi {

     FakeStoreAllUsersResponseDTO findAllUsers() throws IOException;
}
