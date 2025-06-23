package org.example.ecommercespring.services;

import org.example.ecommercespring.dto.ProductDTO;
import org.example.ecommercespring.gateway.ICategoryGateway;
import org.example.ecommercespring.gateway.IProductGateway;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FakeStoreProductService implements IProductService {
    private final IProductGateway productGateway;

    public FakeStoreProductService(IProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    @Override
    public ProductDTO getProduct(int id) throws IOException {
        return this.productGateway.getProduct(id);
    }

    @Override
    public List<ProductDTO> getAllProductsByCategory(String type) throws IOException {
        return this.productGateway.getAllProductsByCategory(type);
    }
}
