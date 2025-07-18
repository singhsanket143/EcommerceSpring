package org.example.ecommercespring.controllers;


import org.example.ecommercespring.dto.ProductDTO;
import org.example.ecommercespring.dto.ProductWithCategoryDTO;
import org.example.ecommercespring.services.IProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id){
        ProductDTO result = this.productService.getProductById(id);

        return ResponseEntity.ok(result);

    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO dto) throws Exception{
        return ResponseEntity.ok(productService.createProduct(dto));
    }

    @GetMapping("/{id}/details")
    public ResponseEntity<ProductWithCategoryDTO> getProductWithCategory(@PathVariable long id) throws Exception {

        ProductWithCategoryDTO dto =  productService.getProductWithCategory(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/batch")
    public ResponseEntity<List<ProductDTO>> getProductsByIds(@RequestBody List<Long> ids) {
        List<ProductDTO> products = productService.getProductsByIds(ids);
        return ResponseEntity.ok(products);
    }

 }
