package org.example.ecommercespring.dto;

import java.util.List;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryProductsResponseDTO {
    private String status;
    private String message;
    private List<ProductDTO> products;

    public List<ProductDTO> getProducts() {
        return products;
    }
}
