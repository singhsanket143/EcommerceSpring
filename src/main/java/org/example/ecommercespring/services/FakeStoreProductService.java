package org.example.ecommercespring.services;

import org.example.ecommercespring.dto.ProductDTO;
import org.example.ecommercespring.dto.ProductsItem;
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
    public ProductDTO getProductById(Long id) throws Exception {
        return this.productGateway.getProductById(id);
    }

    @Override
    public List<ProductsItem> getProductByCategory(String type) throws IOException {
        return this.productGateway.getProductByCategory(type);
    }
}
