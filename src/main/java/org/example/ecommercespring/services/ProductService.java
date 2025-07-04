package org.example.ecommercespring.services;

import org.example.ecommercespring.dto.ProductDTO;
import org.example.ecommercespring.mappers.ProductMapper;
import org.example.ecommercespring.entity.Product;
import org.example.ecommercespring.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public ProductDTO getProductById(Long id) throws Exception {
        return repo.findById(id)
                .map(ProductMapper::toDto)
                .orElseThrow(() -> new Exception("Product not found"));
    }

    public List<ProductDTO> getAll() {
        return repo.findAll()
                .stream()
                .map(ProductMapper::toDto)
                .collect(Collectors.toList());
    }

    public ProductDTO create(ProductDTO dto) {
        Product saved = repo.save(ProductMapper.toEntity(dto));
        return ProductMapper.toDto(saved);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
