package org.example.ecommercespring.gateway.api;

import org.example.ecommercespring.dto.FakeStoreProductResponseDTO;
import org.example.ecommercespring.dto.FakeStoreSingleProductResponseDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FakeStoreProductApi {
    @GET("products")
    Call<FakeStoreProductResponseDTO> getAllProducts();

    @GET("products/{id}")
    Call<FakeStoreSingleProductResponseDTO> getProductById(@Path("id") int id);
}