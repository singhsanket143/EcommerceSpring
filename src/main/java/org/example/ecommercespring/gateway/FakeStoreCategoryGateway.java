package org.example.ecommercespring.gateway;

import com.google.gson.Gson;
import okhttp3.*;
import org.example.ecommercespring.configuration.ClientConfig;
import org.example.ecommercespring.dto.CategoryDTO;
import org.example.ecommercespring.dto.FakeStoreCategoryResponseDTO;
import org.example.ecommercespring.gateway.api.FakeStoreCategoryApi;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class FakeStoreCategoryGateway implements ICategoryGateway{

    private final ClientConfig clientConfig;

    private final FakeStoreCategoryApi fakeStoreCategoryApi;

    public FakeStoreCategoryGateway(ClientConfig clientConfig, FakeStoreCategoryApi fakeStoreCategoryApi) {
        this.clientConfig = clientConfig;
        this.fakeStoreCategoryApi = fakeStoreCategoryApi;
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {

        if(clientConfig.getclientMethod()){
            OkHttpClient client =new OkHttpClient();
            Request request = new Request.Builder().url(clientConfig.getBaseUrl()+"products/category").build();
            Response response =client.newCall(request).execute();
            //ResponseBody responseBody =response.body();
            String jsonBody = response.body().string();
            Gson gson =new Gson();
            FakeStoreCategoryResponseDTO responseDTO = gson.fromJson(jsonBody, FakeStoreCategoryResponseDTO.class);
            return responseDTO.getCategories()
                    .stream()
                    .map(category -> CategoryDTO.builder().name(category).build()).toList();
        }
        else {
        // 1. Make the HTTP request to the FakeStore API to fetch all categories
        FakeStoreCategoryResponseDTO response = this.fakeStoreCategoryApi.getAllFakeCategories().execute().body();

        // 2. Check if the response is null and throw an IOException if it is
        if(response == null) {
            throw new IOException("Failed to fetch categories from FakeStore API");
        }

        // 3. Map the response to a list of CategoryDTO objects
        return response.getCategories().stream()
                .map(category -> CategoryDTO.builder()
                        .name(category)
                        .build())
                .toList();
        }
    }
}
