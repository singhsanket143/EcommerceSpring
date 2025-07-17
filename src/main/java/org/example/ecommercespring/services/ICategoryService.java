package org.example.ecommercespring.services;

import org.example.ecommercespring.dto.CategoryDTO;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

public interface ICategoryService {

    List<CategoryDTO> getAllCategories() throws IOException;

    CategoryDTO getCategoryByName(String name) throws Exception;

    CategoryDTO createCategory(CategoryDTO categoryDTO) throws Exception;

}
