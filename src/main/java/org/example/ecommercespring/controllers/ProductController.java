package org.example.ecommercespring.controllers;


import org.example.ecommercespring.dto.Product;
import org.example.ecommercespring.dto.ProductsItem;
import org.example.ecommercespring.services.IProductService;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) throws Exception {
        Product result = this.productService.getProductById(id);

        return ResponseEntity.ok(result);

    }
    @GetMapping("/category")
    public List<ProductsItem> getProductofCategory(@RequestParam String type) throws IOException {
        return productService.getProductByCategory(type);
    }

}
