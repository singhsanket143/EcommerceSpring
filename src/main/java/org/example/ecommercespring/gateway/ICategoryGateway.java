package org.example.ecommercespring.gateway;

import org.example.ecommercespring.dto.CategoryDTO;
import org.example.ecommercespring.dto.ProductRequestDTO;
import org.example.ecommercespring.dto.ProductResponseDTO;

import java.io.IOException;
import java.util.List;

public interface ICategoryGateway {

    List<CategoryDTO> getAllCategories() throws IOException;

    List<ProductResponseDTO> getProductsByCategory(String categoryType) throws IOException;

    ProductResponseDTO getProductById(Long id) throws IOException;
}
