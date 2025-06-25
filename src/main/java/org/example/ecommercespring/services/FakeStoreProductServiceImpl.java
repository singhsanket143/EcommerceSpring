package org.example.ecommercespring.services;

import org.example.ecommercespring.dto.ProductDTO;
import org.example.ecommercespring.dto.ProductSingleDTO;
import org.example.ecommercespring.gateway.IProductGateway;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FakeStoreProductServiceImpl implements IProductService{

    private final IProductGateway productGateway;

    public FakeStoreProductServiceImpl(IProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    @Override
    public ProductSingleDTO getSingleProduct(int id) throws IOException {
        return productGateway.getSingleProduct(id);
    }

    @Override
    public List<ProductDTO> getAllCategoryProducts(String type) throws IOException{
        return productGateway.getAllCategoryProducts(type);
    }
}
