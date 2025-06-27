package org.example.ecommercespring.services;

import org.example.ecommercespring.dto.ProductDTO;
import org.example.ecommercespring.dto.ProductsItem;

import java.io.IOException;
import java.util.List;

public interface IProductService {

    ProductDTO getProductById(Long id) throws Exception;

    public List<ProductsItem> getProductByCategory(String type)throws IOException;
}
