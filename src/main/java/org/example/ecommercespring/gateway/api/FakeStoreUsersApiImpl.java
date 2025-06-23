package org.example.ecommercespring.gateway.api;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.example.ecommercespring.configuration.AppConfig;
import org.example.ecommercespring.dto.FakeStoreAllUsersResponseDTO;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class FakeStoreUsersApiImpl implements FakeStoreUserApi {
    private final OkHttpClient client;
    private final AppConfig config;

    public FakeStoreUsersApiImpl(OkHttpClient client, AppConfig config) {
        this.client = client;
        this.config = config;
    }

    @Override
    public FakeStoreAllUsersResponseDTO findAllUsers() throws IOException {

        Request request = new Request.Builder().url(config.getBaseUrl() + "users").build();

        try(Response response = client.newCall(request).execute()) {
            if(!response.isSuccessful() || response.body() == null)
                throw new IOException("Failed to fetch users from FakeStore API");

            FakeStoreAllUsersResponseDTO fakeStoreResponse = new Gson()
                    .fromJson(response.body().string(), FakeStoreAllUsersResponseDTO.class);

            if(fakeStoreResponse == null)
                throw new IOException("Failed to fetch users from FakeStore API");

            return fakeStoreResponse;
        }
    }
}
