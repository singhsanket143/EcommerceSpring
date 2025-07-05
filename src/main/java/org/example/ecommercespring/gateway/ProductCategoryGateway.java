package org.example.ecommercespring.gateway;

import org.example.ecommercespring.dto.ProductCategoryDTO;
import org.example.ecommercespring.dto.ProductCategoryResponseDTO;

public interface ProductCategoryGateway {

    ProductCategoryResponseDTO getProductCategory(String Category) throws Exception;
}
