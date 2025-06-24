package org.example.ecommercespring.gateway;

import org.example.ecommercespring.dto.CategoryProductsResponseDTO;
import org.example.ecommercespring.dto.FakeStoreCategoryResponseDTO;
import org.example.ecommercespring.dto.ProductDTO;
import org.example.ecommercespring.dto.SingleProductResponseDTO;
import org.example.ecommercespring.gateway.api.FakeStoreCategoryApi;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class FakeStoreProductGateway implements IProductGateway {
    private final FakeStoreCategoryApi fakeStoreCategoryApi;

    public FakeStoreProductGateway(FakeStoreCategoryApi fakeStoreCategoryApi) {
        this.fakeStoreCategoryApi = fakeStoreCategoryApi;
    }

    @Override
    public ProductDTO getProduct(int id) throws IOException {
        SingleProductResponseDTO response =
                this.fakeStoreCategoryApi.getProduct(id).execute().body();

        // 2. Check if the response is null and throw an IOException if it is
        if (response == null) {
            throw new IOException("Failed to fetch product from FakeStore API");
        }
        //System.out.println(response.getProduct().toString());
        return response.getProduct();
    }

    @Override
    public List<ProductDTO> getAllProductsByCategory(String type) throws IOException {
        CategoryProductsResponseDTO response =
                this.fakeStoreCategoryApi.getProductsByCategory(type).execute().body();
        if (response == null) {
            throw new IOException("Failed to fetch category products from " +
                    "FakeStore API");
        }
        return response.getProducts();
    }
}
