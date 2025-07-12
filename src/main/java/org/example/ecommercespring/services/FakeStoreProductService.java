package org.example.ecommercespring.services;

import org.example.ecommercespring.dto.ProductDTO;
import org.example.ecommercespring.dto.ProductWithCategoryDTO;
import org.example.ecommercespring.gateway.IProductGateway;
import org.springframework.stereotype.Service;

@Service
public class FakeStoreProductService implements IProductService {

    private final IProductGateway productGateway;

    public FakeStoreProductService(IProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    @Override
    public ProductDTO getProductById(Long id) {
        return this.productGateway.getProductById(id);
    }

    public ProductDTO createProduct(ProductDTO dto) {
        return null;
    }

    public ProductWithCategoryDTO getProductWithCategory(Long id) throws  Exception {
        //Not Implemented
        return null;
    }
}
