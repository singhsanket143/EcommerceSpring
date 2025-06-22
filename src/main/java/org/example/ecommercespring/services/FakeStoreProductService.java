package org.example.ecommercespring.services;

import org.example.ecommercespring.dto.ProductListDTO;
import org.example.ecommercespring.dto.ProductSingleDTO;
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
    public List<ProductListDTO> getAllProducts() throws IOException {
        return this.productGateway.getAllProducts();
    }

    @Override
    public ProductSingleDTO getProductById(int id) throws IOException {
        return this.productGateway.getProductById(id);
    }
}
