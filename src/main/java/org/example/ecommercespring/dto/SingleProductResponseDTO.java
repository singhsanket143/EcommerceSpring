package org.example.ecommercespring.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SingleProductResponseDTO {
    private String status;
    private String message;
    private ProductDTO product;

    public ProductDTO getProduct() {
        return product;
    }
}
