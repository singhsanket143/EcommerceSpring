package org.example.ecommercespring.gateway;

import org.example.ecommercespring.configuration.AppConfig;
import org.example.ecommercespring.dto.CategoryDTO;
import org.example.ecommercespring.dto.FakeStoreCategoryResponseDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component("fakeStoreRestTemplateGateway")
public class FakeStoreRestTemplateGateway implements ICategoryGateway{

    private final AppConfig appConfig;
    private final RestTemplate restTemplate;

    public FakeStoreRestTemplateGateway(AppConfig appConfig, RestTemplate restTemplate) {
        this.appConfig = appConfig;
        this.restTemplate = restTemplate;
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        final String CATEGORIES_ENDPOINT = appConfig.getBaseUrl() + "products/category";

        FakeStoreCategoryResponseDTO response = restTemplate
                .getForEntity( CATEGORIES_ENDPOINT, FakeStoreCategoryResponseDTO.class).getBody();

        if(response == null )
            throw new IOException("Error getting categories");

        return response.getCategories()
                .stream().map(CategoryDTO::new).toList();
    }
}
