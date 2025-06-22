package org.example.ecommercespring.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FakeStoreSingleProductResponseDTO {
    private String status;
    private String message;
    private ProductSingleDTO product;
}