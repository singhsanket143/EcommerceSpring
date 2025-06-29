package org.example.ecommercespring.gateway.api;

import org.example.ecommercespring.dto.FakeStoreProductResponseDTO;
import org.example.ecommercespring.dto.ProductOfCategoryResponseDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.io.IOException;

public interface FakeStoreProductApi {
    @GET("products/{id}")
    Call<FakeStoreProductResponseDTO> getFakeProduct(@Path("id") Long id) throws IOException;

    @GET("products/category")
    Call<ProductOfCategoryResponseDTO>getallproductscategory(@Query("type") String type) throws IOException;
}
