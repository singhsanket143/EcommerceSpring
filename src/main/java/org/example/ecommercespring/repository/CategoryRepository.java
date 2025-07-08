package org.example.ecommercespring.repository;

import org.example.ecommercespring.entity.Category;
import org.example.ecommercespring.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

   Optional<Category> findByName(String name);



}