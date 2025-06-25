package org.example.ecommercespring.gateway;

import org.example.ecommercespring.dto.ProductDTO;
import org.example.ecommercespring.dto.ProductSingleDTO;

import java.io.IOException;
import java.util.List;

public interface IProductGateway {
    ProductSingleDTO getSingleProduct(int id) throws IOException;
    List<ProductDTO> getAllCategoryProducts(String type) throws IOException;

}
