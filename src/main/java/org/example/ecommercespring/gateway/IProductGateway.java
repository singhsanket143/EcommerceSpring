package org.example.ecommercespring.gateway;

import org.example.ecommercespring.dto.ProductDTO;
import org.example.ecommercespring.dto.ProductsItem;

import java.io.IOException;
import java.util.List;

public interface IProductGateway {

    ProductDTO getProductById(Long id) throws Exception;

    public List<ProductsItem> getProductByCategory(String type) throws IOException;
}
