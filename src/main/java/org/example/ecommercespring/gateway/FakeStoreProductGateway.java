package org.example.ecommercespring.gateway;

import org.example.ecommercespring.dto.FakeStoreProductResponseDTO;
import org.example.ecommercespring.dto.ProductDTO;
import org.example.ecommercespring.gateway.api.FakeStoreProductApi;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class FakeStoreProductGateway implements IProductGateway {

    private final FakeStoreProductApi fakeStoreProductApi;

    public FakeStoreProductGateway(FakeStoreProductApi fakeStoreProductApi) {
        this.fakeStoreProductApi = fakeStoreProductApi;
    }

    @Override
    public List<ProductDTO> getAllProducts() throws IOException {
        FakeStoreProductResponseDTO response = this.fakeStoreProductApi.getAllProducts().execute().body();

        if (response == null || response.getProducts() == null) {
            throw new IOException("Failed to fetch products from FakeStore API");
        }

        return response.getProducts();
    }
}