package org.example.ecommercespring.dto;

import java.util.List;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AllProductsOfCategoryDTO {
    private Long categoryId;
    private String name;
    private List<ProductDTO> products;
}