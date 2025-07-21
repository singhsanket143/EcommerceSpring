package org.example.ecommercespring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductCategoryResponseDTO {
    private String status;
    private String message;
    private List<ProductCategoryDTO> products;

    public static class ProductWithCategoryDTO  {


    }
}
