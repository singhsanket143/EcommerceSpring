package org.example.ecommercespring.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FakeStoreSingleProductResponseDTO {
    private String status;
    private String message;
    private ProductSingleDTO product;
}
