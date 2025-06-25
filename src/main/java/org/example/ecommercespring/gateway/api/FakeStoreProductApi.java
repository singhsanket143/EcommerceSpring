package org.example.ecommercespring.gateway.api;

import lombok.Getter;
import org.example.ecommercespring.dto.FakeStoreCategoryProductResponseDTO;
import org.example.ecommercespring.dto.FakeStoreSingleProductResponseDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.io.IOException;

public interface FakeStoreProductApi {

    @GET("products/{id}")
    Call<FakeStoreSingleProductResponseDTO> getSingleProduct(@Path("id") int id) throws IOException;

    @GET("products/category")
    Call<FakeStoreCategoryProductResponseDTO> getAllFakeCategoryProducts(@Query("type")String type) throws IOException;
}
