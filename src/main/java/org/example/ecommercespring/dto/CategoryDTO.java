package org.example.ecommercespring.dto;

import lombok.*;
import org.example.ecommercespring.entity.Category;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
    private Long id;
    private String name;
}
