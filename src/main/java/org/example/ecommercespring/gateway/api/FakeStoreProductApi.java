package org.example.ecommercespring.gateway.api;

import org.example.ecommercespring.dto.FakeStoreAllProductResponseDTO;
import org.example.ecommercespring.dto.FakeStoreSingleProductDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface FakeStoreProductApi {

    @GET("products/{id}")
    Call<FakeStoreSingleProductDTO> getProductById(@Path("id") Long id);

    @GET("products/category")
    Call<FakeStoreAllProductResponseDTO> findProductsByCategory(@Query("type") String type);
}
