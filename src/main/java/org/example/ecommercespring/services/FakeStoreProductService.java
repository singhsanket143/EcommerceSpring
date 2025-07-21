package org.example.ecommercespring.services;

import org.example.ecommercespring.dto.ProductDTO;
import org.example.ecommercespring.gateway.IProductGateway;
import org.springframework.stereotype.Service;

@Service
public class FakeStoreProductService implements IProductService {

    private final IProductGateway productGateway;

    public FakeStoreProductService(IProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    @Override
    public ProductDTO getProductById(Long id) throws Exception {
        return this.productGateway.getProductById(id);
    }

    @Override
    public ProductDTO createProduct(ProductDTO dto) throws Exception {
        return null;
    }
}
