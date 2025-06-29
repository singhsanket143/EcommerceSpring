package org.example.ecommercespring.gateway;

import org.example.ecommercespring.dto.Product;
import org.example.ecommercespring.dto.ProductsItem;

import java.io.IOException;
import java.util.List;

public interface IProductGateway {

    Product getProductById(Long id) throws Exception;

    public List<ProductsItem> getProductByCategory(String type) throws IOException;
}
