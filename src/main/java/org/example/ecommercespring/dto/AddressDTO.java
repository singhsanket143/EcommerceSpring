package org.example.ecommercespring.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressDTO {
    private String city;
    private String street;
    private String number;
    private String zipcode;
}
