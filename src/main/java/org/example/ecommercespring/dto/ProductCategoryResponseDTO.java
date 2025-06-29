package org.example.ecommercespring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductCategoryResponseDTO {
    private String status;
    private String message;
    private List<ProductCategoryDTO> products;
}
