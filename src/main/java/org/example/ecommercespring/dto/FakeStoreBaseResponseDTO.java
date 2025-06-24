package org.example.ecommercespring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FakeStoreBaseResponseDTO {
    private String status;
    private String message;
}