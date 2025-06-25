package org.example.ecommercespring.services;

import org.example.ecommercespring.dto.ProductDTO;
import org.example.ecommercespring.dto.ProductSingleDTO;

import java.io.IOException;
import java.util.List;

public interface IProductService {
    ProductSingleDTO getSingleProduct(int id) throws IOException;
    List<ProductDTO> getAllCategoryProducts(String category) throws IOException;

}
