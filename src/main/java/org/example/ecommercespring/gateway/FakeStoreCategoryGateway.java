package org.example.ecommercespring.gateway;

import org.example.ecommercespring.dto.*;
import org.example.ecommercespring.gateway.api.FakeStoreCategoryApi;
import org.example.ecommercespring.gateway.api.FakeStoreProductApi;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class FakeStoreCategoryGateway implements ICategoryGateway{

    private final FakeStoreCategoryApi fakeStoreCategoryApi;

    private final FakeStoreProductApi fakeStoreProductApi;

    public FakeStoreCategoryGateway(FakeStoreCategoryApi fakeStoreCategoryApi, FakeStoreProductApi fakeStoreProductApi) {
        this.fakeStoreCategoryApi = fakeStoreCategoryApi;
        this.fakeStoreProductApi = fakeStoreProductApi;
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
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

    @Override
    public List<ProductResponseDTO> getProductsByCategory(String categoryType) throws IOException {

        FakeStoreAllProductResponseDTO response =  fakeStoreProductApi.findProductsByCategory(categoryType).execute().body();

        if(response == null )
            throw new IOException("Failed to fetch products from FakeStore API");

        return response.getProducts()
                .stream()
                .map(ProductResponseDTO::toProductDTO)
                .toList();
    }

    @Override
    public ProductResponseDTO getProductById(Long id) throws IOException {

        FakeStoreSingleProductDTO response = fakeStoreProductApi.getProductById(id).execute().body();

        if(response == null)
            throw new IOException("Failed to fetch product from FakeStore API");

        return ProductResponseDTO.toProductDTO(response.getProduct());
    }


}
