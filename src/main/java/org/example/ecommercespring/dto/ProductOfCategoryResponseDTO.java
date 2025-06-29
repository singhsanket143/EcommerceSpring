package org.example.ecommercespring.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductOfCategoryResponseDTO {
    private String message;
    private String status;
    private List<ProductsItem> products;
}