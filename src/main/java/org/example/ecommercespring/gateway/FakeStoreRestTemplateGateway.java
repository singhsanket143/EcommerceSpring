package org.example.ecommercespring.gateway;

import org.example.ecommercespring.dto.CategoryDTO;
import org.example.ecommercespring.dto.FakeStoreCategoryResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component("fakeStoreRestTemplateGateway")
public class FakeStoreRestTemplateGateway implements ICategoryGateway {

    private final RestTemplate restTemplate;
    private final String apiUrl;

    public FakeStoreRestTemplateGateway(RestTemplate restTemplate, @Value("https://fakestoreapi.in/api") String apiUrl) {
        this.restTemplate = restTemplate;
        this.apiUrl = apiUrl;
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        try {
            String url = apiUrl + "/products/category";
            FakeStoreCategoryResponseDTO response = restTemplate.getForObject(
                    url,
                    FakeStoreCategoryResponseDTO.class);

            if (response == null || response.getCategories() == null) {
                throw new IOException("No categories found");
            }

            return response.getCategories().stream()
                    .map(name -> new CategoryDTO(name))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new IOException("Failed to fetch categories", e);
        }
    }
}