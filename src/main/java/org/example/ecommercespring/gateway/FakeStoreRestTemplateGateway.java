package org.example.ecommercespring.gateway;

import org.example.ecommercespring.dto.CategoryDTO;
import org.example.ecommercespring.dto.FakeStoreCategoryResponseDTO;
import org.example.ecommercespring.mappers.GetAllCategoriesMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@Component("fakeStoreRestTemplateGateway")
public class FakeStoreRestTemplateGateway implements ICategoryGateway{

    private final RestTemplateBuilder restTemplateBuilder;

    public FakeStoreRestTemplateGateway(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        String url = "https://fakestoreapi.in/api/products/category";

        ResponseEntity<FakeStoreCategoryResponseDTO> response =  restTemplate.getForEntity(url, FakeStoreCategoryResponseDTO.class);
        if (response.getBody() == null) {
            throw new IOException("Failed to fetch categories from FakeStore API");
        }
        return GetAllCategoriesMapper.toCategoryDto(response.getBody());

    }
}
