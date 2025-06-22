package org.example.ecommercespring.gateway.api;

import org.example.ecommercespring.dto.FakeStoreProductResponseDTO;
import retrofit2.Call;
import retrofit2.http.GET;

public interface FakeStoreProductApi {
    @GET("products")
    Call<FakeStoreProductResponseDTO> getAllProducts();
}