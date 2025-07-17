package org.example.ecommercespring.repository;

import org.example.ecommercespring.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ICategoryRepository extends JpaRepository<Category,Long> {

    Optional<Category>findByName(String name);

}
