package org.example.ecommercespring.controllers;

import org.example.ecommercespring.dto.ProductDTO;
import org.example.ecommercespring.services.IProductService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductDTO> getAllProducts() throws IOException {
        return this.productService.getAllProducts();
    }
}