package org.example.ecommercespring.services;

import org.example.ecommercespring.dto.ProductCategoryResponseDTO;

public interface ProductCategoryService {
    ProductCategoryResponseDTO fetchProductsByCategory(String category) throws Exception;
}
