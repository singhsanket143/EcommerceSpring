package org.example.ecommercespring.gateway;

import com.google.gson.Gson;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.example.ecommercespring.configuration.ClientConfig;
import org.example.ecommercespring.dto.FakeStoreProductResponseDTO;
import org.example.ecommercespring.dto.Product;
import org.example.ecommercespring.dto.ProductOfCategoryResponseDTO;
import org.example.ecommercespring.dto.ProductsItem;
import org.example.ecommercespring.gateway.api.FakeStoreProductApi;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriBuilder;

import java.io.IOException;
import java.util.List;
@Component
public class FakeStoreProductGateway implements IProductGateway {

    private final FakeStoreProductApi fakeStoreProductApi;
    private final ClientConfig clientConfig;
    public FakeStoreProductGateway(FakeStoreProductApi fakeStoreProductApi, ClientConfig clientConfig) {
        this.fakeStoreProductApi = fakeStoreProductApi;
        this.clientConfig = clientConfig;
    }

    @Override
    public Product getProductById(Long id) throws Exception {
        if(clientConfig.getclientMethod()) {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url(clientConfig.getBaseUrl() + "products/" + id).build();
            Response response = client.newCall(request).execute();
            //ResponseBody responseBody =response.body();
            String jsonBody = response.body().string();
            Gson gson = new Gson();
            FakeStoreProductResponseDTO responseDTO = gson.fromJson(jsonBody,FakeStoreProductResponseDTO.class);
            return responseDTO.getProduct();
        }
        else {
            FakeStoreProductResponseDTO response = this.fakeStoreProductApi.getFakeProduct(id).execute().body();
            if (response == null) {
                throw new Exception("Product not found");
            }

            return response.getProduct();
        }
    }

    @Override
    public List<ProductsItem> getProductByCategory(String type) throws IOException {

        if(clientConfig.getclientMethod()) {
            OkHttpClient client = new OkHttpClient();
            HttpUrl.Builder urlBuilder =HttpUrl.parse(clientConfig.getBaseUrl()+"products").newBuilder();
            urlBuilder.addQueryParameter("type",type);
            String url= urlBuilder.build().toString();
            //System.out.println(url);
            Request request = new Request.Builder().url(url).build();
            Response response = client.newCall(request).execute();
            //ResponseBody responseBody =response.body();
            String jsonBody = response.body().string();
            Gson gson = new Gson();
            ProductOfCategoryResponseDTO responseDTO = gson.fromJson(jsonBody,ProductOfCategoryResponseDTO.class);
            return responseDTO.getProducts().stream()
                    .map(productsItem -> ProductsItem.builder()
                            .id(productsItem.getId())
                            .title(productsItem.getTitle())
                            .image(productsItem.getImage())
                            .price(productsItem.getPrice())
                            .description(productsItem.getDescription())
                            .brand(productsItem.getBrand())
                            .model(productsItem.getModel())
                            .color(productsItem.getColor())
                            .category(productsItem.getCategory())
                            .discount(productsItem.getDiscount())
                            .onSale(productsItem.getOnSale()).build()).toList();
        }
        else {

            ProductOfCategoryResponseDTO response = this.fakeStoreProductApi.getallproductscategory(type).execute().body();
            if (response == null) {
                throw new IOException();

            } else return response.getProducts().stream()
                    .map(productsItem -> ProductsItem.builder()
                            .id(productsItem.getId())
                            .title(productsItem.getTitle())
                            .image(productsItem.getImage())
                            .price(productsItem.getPrice())
                            .description(productsItem.getDescription())
                            .brand(productsItem.getBrand())
                            .model(productsItem.getModel())
                            .color(productsItem.getColor())
                            .category(productsItem.getCategory())
                            .discount(productsItem.getDiscount())
                            .onSale(productsItem.getOnSale()).build()).toList();
        }
    }

}
