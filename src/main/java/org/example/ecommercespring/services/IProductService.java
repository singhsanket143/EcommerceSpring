package org.example.ecommercespring.services;

import org.example.ecommercespring.dto.ProductDTO;

public interface IProductService {

    ProductDTO getProductById(Long id) throws Exception;
}
