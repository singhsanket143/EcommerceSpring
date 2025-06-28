package org.example.ecommercespring.services;

import org.example.ecommercespring.dto.Product;
import org.example.ecommercespring.dto.ProductsItem;

import java.io.IOException;
import java.util.List;

public interface IProductService {

    Product getProductById(Long id) throws Exception;

    public List<ProductsItem> getProductByCategory(String type)throws IOException;
}
