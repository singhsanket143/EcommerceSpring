package org.example.ecommercespring.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FakeStoreProductResponseDTO {
    private String status;
    private String message;
    private List<ProductDTO> products;
}