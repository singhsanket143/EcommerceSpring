package org.example.ecommercespring.gateway;

import org.example.ecommercespring.dto.FakeStoreProductResponseDTO;
import org.example.ecommercespring.dto.ProductDTO;
import org.example.ecommercespring.dto.ProductOfCategoryResponseDTO;
import org.example.ecommercespring.dto.ProductsItem;
import org.example.ecommercespring.gateway.api.FakeStoreProductApi;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
@Component
public class FakeStoreProductGateway implements IProductGateway {

    private final FakeStoreProductApi fakeStoreProductApi;
    public FakeStoreProductGateway(FakeStoreProductApi fakeStoreProductApi) {
        this.fakeStoreProductApi = fakeStoreProductApi;
    }

    @Override
    public ProductDTO getProductById(Long id) throws Exception {
         FakeStoreProductResponseDTO response = this.fakeStoreProductApi.getFakeProduct(id).execute().body();
        if (response == null) {
            throw new Exception("Product not found");
        }

        return response.getProductDTO();
    }

    @Override
    public List<ProductsItem> getProductByCategory(String type) throws IOException {
        ProductOfCategoryResponseDTO response= this.fakeStoreProductApi.getallproductscategory(type).execute().body();
        if(response==null){
            throw new IOException();

        }
        else return response.getProducts().stream()
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
