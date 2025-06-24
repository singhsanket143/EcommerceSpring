package org.example.ecommercespring.gateway;

import org.example.ecommercespring.dto.ProductDTO;

public interface IProductGateway {

    ProductDTO getProductById(Long id) throws Exception;
}
