package org.example.ecommercespring.services;

import org.example.ecommercespring.dto.ProductResponseDTO;

import java.io.IOException;
import java.util.List;

public interface IProductService {

    List<ProductResponseDTO> getProductsByCategory(String category) throws IOException;

    ProductResponseDTO findProductById(Long id) throws IOException;
}
