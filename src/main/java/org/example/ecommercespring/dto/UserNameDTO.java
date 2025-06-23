package org.example.ecommercespring.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserNameDTO {
    private String firstname;
    private String middlename;
    private String lastname;
}
