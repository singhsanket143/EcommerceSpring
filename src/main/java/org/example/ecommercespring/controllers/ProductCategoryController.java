package org.example.ecommercespring.controllers;

import org.example.ecommercespring.dto.ProductCategoryResponseDTO;
import org.example.ecommercespring.services.ProductCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductCategoryController {
public final ProductCategoryService productCategoryService;
public ProductCategoryController(ProductCategoryService productCategoryService){
    this.productCategoryService = productCategoryService;
}

    @GetMapping("/category")
    public ResponseEntity<ProductCategoryResponseDTO> getProductsByCategory(@RequestParam("type") String type) throws Exception {
        System.out.println("Fetching products for category: " + type);
    ProductCategoryResponseDTO response = productCategoryService.fetchProductsByCategory(type);

       return ResponseEntity.ok(response);
    }
}
