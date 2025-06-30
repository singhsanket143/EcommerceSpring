package org.example.ecommercespring.gateway;

import org.example.ecommercespring.dto.CategoryDTO;
import org.example.ecommercespring.dto.FakeStoreCategoryResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@Component("fakeStoreRestTemplateGateway")
public class FakeStoreRestTemplateGateway implements ICategoryGateway {
    @Value("${fake-store.apiurl}")
    private String fakestoreapiUrl;
    private final RestTemplate restTemplate;

    public FakeStoreRestTemplateGateway(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        System.out.println("inside rest template api call");
        String fakestoreCategoryurl = this.fakestoreapiUrl + "products" +
                "/category";
        FakeStoreCategoryResponseDTO response =
                this.restTemplate.getForObject(fakestoreCategoryurl,
                        FakeStoreCategoryResponseDTO.class);
        if (response == null) {
            throw new IOException("Failed to fetch categories from FakeStore API");
        }
        return response.getCategories().stream()
                .map(category -> CategoryDTO.builder()
                        .name(category).build()).toList();
    }
}
