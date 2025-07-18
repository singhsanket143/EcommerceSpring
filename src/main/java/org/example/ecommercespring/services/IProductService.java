package org.example.ecommercespring.services;

import org.example.ecommercespring.dto.ProductDTO;
import org.example.ecommercespring.dto.ProductWithCategoryDTO;

import java.util.List;

public interface IProductService {

    ProductDTO getProductById(Long id);
    ProductDTO createProduct(ProductDTO dto) throws Exception;
    ProductWithCategoryDTO getProductWithCategory(Long id) throws  Exception;

    List<ProductDTO> getProductsByIds(List<Long> ids);
}
