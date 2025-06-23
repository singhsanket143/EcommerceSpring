package org.example.ecommercespring.gateway;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.example.ecommercespring.dto.CategoryDTO;
import org.example.ecommercespring.dto.FakeStoreCategoryResponseDTO;
import org.example.ecommercespring.gateway.api.FakeStoreCategoryApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Component
@Primary
public class FakeStoreCategoryGateway implements ICategoryGateway {

    private final HttpClientDelegate delegate;

    public FakeStoreCategoryGateway(
            @Autowired(required = false) OkHttpClient okHttpClient,
            @Autowired(required = false) FakeStoreCategoryApi retrofitApi,
            ObjectMapper objectMapper) {

        if (okHttpClient != null) {
            this.delegate = new OkHttpDelegate(okHttpClient, objectMapper);
        } else if (retrofitApi != null) {
            this.delegate = new RetrofitDelegate(retrofitApi);
        } else {
            throw new IllegalStateException("No HTTP client implementation available");
        }
    }
    private interface HttpClientDelegate {
        List<CategoryDTO> getAllCategories() throws IOException;
    }

    private static class OkHttpDelegate implements HttpClientDelegate {
        private final OkHttpClient client;
        private final ObjectMapper mapper;
        private static final String BASE_URL = "https://fakestoreapi.in/api/";

        OkHttpDelegate(OkHttpClient client, ObjectMapper mapper) {
            this.client = client;
            this.mapper = mapper;
        }

        @Override
        public List<CategoryDTO> getAllCategories() throws IOException {
            Request request = new Request.Builder()
                    .url(BASE_URL + "products/category")
                    .build();

            try (Response response = client.newCall(request).execute()) {
                if (!response.isSuccessful() || response.body() == null) {
                    throw new IOException("HTTP request failed: " + response);
                }

                String responseBody = Objects.requireNonNull(response.body()).string();
                FakeStoreCategoryResponseDTO apiResponse = mapper.readValue(
                        responseBody,
                        FakeStoreCategoryResponseDTO.class);

                return apiResponse.getCategories().stream()
                        .map(CategoryDTO::new)
                        .toList();
            }
        }
    }

    private static class RetrofitDelegate implements HttpClientDelegate {
        private final FakeStoreCategoryApi api;

        RetrofitDelegate(FakeStoreCategoryApi api) {
            this.api = api;
        }

        @Override
        public List<CategoryDTO> getAllCategories() throws IOException {
            return api.getAllFakeCategories()
                    .execute()
                    .body()
                    .getCategories()
                    .stream()
                    .map(CategoryDTO::new)
                    .toList();
        }
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        return delegate.getAllCategories();
    }
}