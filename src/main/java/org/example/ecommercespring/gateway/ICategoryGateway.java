package org.example.ecommercespring.gateway;

import org.example.ecommercespring.dto.CategoryDTO;

import java.io.IOException;
import java.util.List;

public interface ICategoryGateway {

    List<CategoryDTO> getAllCategories() throws IOException;
}
