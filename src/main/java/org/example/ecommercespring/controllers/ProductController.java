package org.example.ecommercespring.controllers;


import org.example.ecommercespring.dto.ProductDTO;
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
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) throws Exception {
        ProductDTO result = this.productService.getProductById(id);

        return ResponseEntity.ok(result);

    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO dto) throws IOException {
        return ResponseEntity.ok(productService.createProduct(dto));
    }
    @GetMapping("/AllProduct/Category/{id}")
    public ResponseEntity<List<ProductDTO>> getProductsOfAllCategory(@PathVariable("id") Long id) throws Exception {
        List<ProductDTO> productDTO = productService.getAllProductsOfCategory(id);
        return ResponseEntity.ok().body(productDTO);
    }
}
