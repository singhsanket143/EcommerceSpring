package org.example.ecommercespring.services;

import org.example.ecommercespring.dto.ProductDTO;

import java.io.IOException;
import java.util.List;

public interface IProductService {

    ProductDTO getProductById(Long id) throws Exception;
    ProductDTO createProduct(ProductDTO dto) throws IOException;
    List<ProductDTO> getAllProductsOfCategory(Long id) throws Exception;

}
