package org.example.ecommercespring.gateway;

import com.google.gson.Gson;
import io.github.cdimascio.dotenv.Dotenv;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.example.ecommercespring.dto.SingleUserResponseDTO;
import org.example.ecommercespring.dto.UserDTO;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class FakeStoreUserGateway implements IUserGateway {
    private final OkHttpClient okHttpClient;
    private final Gson gson;

    public FakeStoreUserGateway(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
        this.gson = new Gson();
    }

    @Override
    public UserDTO getUser(int id) throws IOException {
        Dotenv dotenv = Dotenv.load();
        String baseUrl = dotenv.get("FAKESTOREAPIURL");
        String userUrl = baseUrl + "users/" + id;
        Request userequest = new Request.Builder()
                .url(userUrl)
                .build();
        Response response = okHttpClient.newCall(userequest).execute();
        if (response.isSuccessful()) {
            String responseBody = response.body().string();
            System.out.println("Response: " + responseBody);
            SingleUserResponseDTO singleUserResponseDTO = gson.fromJson(responseBody,
                    SingleUserResponseDTO.class);
            System.out.println(singleUserResponseDTO.getUser().toString());
            return singleUserResponseDTO.getUser();
        } else {
            System.out.println("user request failed with code: " + response.code());
            throw new IOException("Failed to fetch user from " +
                    "FakeStore API");
        }
    }
}
