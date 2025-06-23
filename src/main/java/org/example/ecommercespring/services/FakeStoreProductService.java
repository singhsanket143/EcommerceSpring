package org.example.ecommercespring.services;

import org.example.ecommercespring.dto.ProductResponseDTO;
import org.example.ecommercespring.gateway.ICategoryGateway;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FakeStoreProductService implements IProductService {

    private final ICategoryGateway categoryGateway;

    public FakeStoreProductService(ICategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }

    @Override
    public List<ProductResponseDTO> getProductsByCategory(String category) throws IOException {
        return categoryGateway.getProductsByCategory(category);
    }

    @Override
    public ProductResponseDTO findProductById(Long id) throws IOException {
        return categoryGateway.getProductById(id);
    }
}
