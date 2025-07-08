package org.example.ecommercespring.services;

import org.example.ecommercespring.dto.AllProductsOfCategoryDTO;
import org.example.ecommercespring.dto.CategoryDTO;

import java.io.IOException;
import java.util.List;

public interface ICategoryService {

    List<CategoryDTO> getAllCategories() throws IOException;
    CategoryDTO createCategory(CategoryDTO categoryDTO);
    CategoryDTO getByName(String name) throws Exception;
    AllProductsOfCategoryDTO getAllProductsOfCategory(Long categoryId) throws Exception;

}
