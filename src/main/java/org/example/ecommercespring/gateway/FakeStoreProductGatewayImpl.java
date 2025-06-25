package org.example.ecommercespring.gateway;

import org.example.ecommercespring.dto.FakeStoreCategoryProductResponseDTO;
import org.example.ecommercespring.dto.FakeStoreSingleProductResponseDTO;
import org.example.ecommercespring.dto.ProductDTO;
import org.example.ecommercespring.dto.ProductSingleDTO;
import org.example.ecommercespring.gateway.api.FakeStoreProductApi;
import org.springframework.stereotype.Component;
import retrofit2.Call;

import java.io.IOException;
import java.util.List;

@Component
public class FakeStoreProductGatewayImpl implements IProductGateway{
    private final FakeStoreProductApi fakeStoreProductApi;

    public FakeStoreProductGatewayImpl(FakeStoreProductApi fakeStoreProductApi) {
        this.fakeStoreProductApi = fakeStoreProductApi;
    }

    @Override
    public ProductSingleDTO getSingleProduct(int id) throws IOException {
        FakeStoreSingleProductResponseDTO response = this.fakeStoreProductApi.getSingleProduct(id).execute().body();
        if(response == null) {
            throw new IOException("Failed to fetch categories from FakeStore API");
        }
        return response.getProduct();
    }

    @Override
    public List<ProductDTO> getAllCategoryProducts(String type) throws IOException {
        FakeStoreCategoryProductResponseDTO response = this.fakeStoreProductApi.getAllFakeCategoryProducts(type).execute().body();
        if(response == null) {
            throw new IOException("Failed to fetch categories from FakeStore API");
        }
        return response.getProducts();
    }
}
