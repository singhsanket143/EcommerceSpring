package org.example.ecommercespring.controllers;


import org.example.ecommercespring.Exceptions.ProductNotFoundException;
import org.example.ecommercespring.dto.ProductDTO;
import org.example.ecommercespring.services.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id:[0-9]+}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) throws Exception {
        ProductDTO result = this.productService.getProductById(id);

        return ResponseEntity.ok(result);

    }
    @PostMapping
    public ResponseEntity<ProductDTO> saveProduct(@RequestBody ProductDTO productDTO) throws Exception {
        return ResponseEntity.ok(productService.createProduct(productDTO));
    }

}
