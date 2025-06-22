package org.example.ecommercespring.gateway;

import org.example.ecommercespring.dto.ProductDTO;

import java.io.IOException;
import java.util.List;

public interface IProductGateway {
    List<ProductDTO> getAllProducts() throws IOException;
}