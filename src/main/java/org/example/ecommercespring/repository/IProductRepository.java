package org.example.ecommercespring.repository;

import org.example.ecommercespring.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Long> {

}
