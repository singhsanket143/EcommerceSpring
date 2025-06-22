package org.example.ecommercespring.gateway;

import org.example.ecommercespring.dto.FakeStoreProductResponseDTO;
import org.example.ecommercespring.dto.FakeStoreSingleProductResponseDTO;
import org.example.ecommercespring.dto.ProductListDTO;
import org.example.ecommercespring.dto.ProductSingleDTO;
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
    public List<ProductListDTO> getAllProducts() throws IOException {
        FakeStoreProductResponseDTO response = this.fakeStoreProductApi.getAllProducts().execute().body();

        if (response == null || response.getProducts() == null) {
            throw new IOException("Failed to fetch products from FakeStore API");
        }

        return response.getProducts();
    }

    @Override
    public ProductSingleDTO getProductById(int id) throws IOException {
        FakeStoreSingleProductResponseDTO response = this.fakeStoreProductApi.getProductById(id).execute().body();
        if (response == null || response.getProduct() == null) {
            throw new IOException("Product not found for id: " + id);
        }
        return response.getProduct();
    }
}