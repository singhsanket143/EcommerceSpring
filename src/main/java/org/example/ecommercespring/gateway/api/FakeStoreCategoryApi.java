package org.example.ecommercespring.gateway.api;

import org.example.ecommercespring.dto.CategoryProductsResponseDTO;
import org.example.ecommercespring.dto.FakeStoreCategoryResponseDTO;
import org.example.ecommercespring.dto.SingleProductResponseDTO;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.io.IOException;

public interface FakeStoreCategoryApi {

    @GET("products/category")
    Call<FakeStoreCategoryResponseDTO> getAllFakeCategories() throws IOException;

    @GET("products/{id}")
    Call<SingleProductResponseDTO> getProduct(@Path("id") int id);

    @GET("products/category")
    Call<CategoryProductsResponseDTO> getProductsByCategory(@Query("type") String type);
}
