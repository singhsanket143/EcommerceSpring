package org.example.ecommercespring.services;

import org.example.ecommercespring.dto.ProductCategoryResponseDTO;
import org.example.ecommercespring.gateway.ProductCategoryGateway;
import org.springframework.stereotype.Service;

@Service
public class FakeStoreProductCategoryService implements ProductCategoryService {
private final ProductCategoryGateway productCategoryGateway;

public FakeStoreProductCategoryService(ProductCategoryGateway productCategoryGateway) {
    this.productCategoryGateway = productCategoryGateway;
}

    @Override
    public ProductCategoryResponseDTO fetchProductsByCategory(String category) throws Exception {
        return productCategoryGateway.getProductCategory(category);
    }
}
