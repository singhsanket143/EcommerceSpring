package org.example.ecommercespring.gateway;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Request;
import okhttp3.Response;
import org.example.ecommercespring.dto.ProductCategoryResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FakeStoreProductCategoryGateway implements ProductCategoryGateway {
    @Value("${URL}")
    private String Url;

    private final okhttp3.OkHttpClient okHttpClient;
    @Autowired
    private ObjectMapper objectMapper;

    public FakeStoreProductCategoryGateway(okhttp3.OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    @Override
    public ProductCategoryResponseDTO getProductCategory(String Category) throws Exception {
        String url = Url + Category;

        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        try (Response response = okHttpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new RuntimeException("Failed to fetch products");
            }

            return objectMapper.readValue(response.body().string(), ProductCategoryResponseDTO.class);
        }
    }
}
