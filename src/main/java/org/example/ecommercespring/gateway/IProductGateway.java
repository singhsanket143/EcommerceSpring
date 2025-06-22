package org.example.ecommercespring.gateway;

import org.example.ecommercespring.dto.ProductListDTO;
import org.example.ecommercespring.dto.ProductSingleDTO;

import java.io.IOException;
import java.util.List;

public interface IProductGateway {
    List<ProductListDTO> getAllProducts() throws IOException;
    ProductSingleDTO getProductById(int id) throws IOException;
}