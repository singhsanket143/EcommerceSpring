package org.example.ecommercespring.gateway;

import org.example.ecommercespring.dto.CategoryDTO;
import org.example.ecommercespring.dto.FakeStoreCategoryResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.util.List;

@Component("fakeStoreRestTemplateGateway")
public class FakeStoreRestTemplateGateway implements ICategoryGateway{
    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        RestTemplate restTemplate =new RestTemplate();
        String Url="https://fakestoreapi.in/api/products/category";
        ResponseEntity<FakeStoreCategoryResponseDTO> response=restTemplate.getForEntity(Url,FakeStoreCategoryResponseDTO.class);
        //System.out.println(response.getBody().getCategories());
        return response.getBody().getCategories().stream().map(category -> CategoryDTO.builder()
                        .name(category)
                        .build())
                .toList();
    }
}
