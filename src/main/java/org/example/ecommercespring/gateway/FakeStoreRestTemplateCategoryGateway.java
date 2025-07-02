package org.example.ecommercespring.gateway;

import org.example.ecommercespring.Mapper.FakeStoreCategrory;
import org.example.ecommercespring.dto.CategoryDTO;
import org.example.ecommercespring.dto.FakeStoreCategoryResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;
@Component("FakeStoreRestTemplate")
public class FakeStoreRestTemplateCategoryGateway implements ICategoryGateway {
    @Value("${BASE_URL_1}")
    private String Url;
    private final RestTemplate restTemplate;
    public FakeStoreRestTemplateCategoryGateway(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        String url = Url;

        ResponseEntity<FakeStoreCategoryResponseDTO> response = restTemplate.getForEntity(url, FakeStoreCategoryResponseDTO.class);

        return FakeStoreCategrory.toCategoryDTO(response.getBody());
    }
}
