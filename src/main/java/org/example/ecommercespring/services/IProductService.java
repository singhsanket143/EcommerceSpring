package org.example.ecommercespring.services;

import org.example.ecommercespring.dto.CategoryDTO;
import org.example.ecommercespring.dto.ProductDTO;

import java.io.IOException;
import java.util.List;

public interface IProductService {
    ProductDTO getProduct(int id) throws IOException;

    List<ProductDTO> getAllProductsByCategory(String type) throws IOException;
}
