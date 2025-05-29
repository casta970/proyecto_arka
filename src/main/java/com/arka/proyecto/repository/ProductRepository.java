package com.arka.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arka.proyecto.model.Category;
import com.arka.proyecto.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
    List<Product> findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String name, String description);

    List<Product> findAllByOrderByNameAsc();

    List<Product> findByPriceBetween(double minPrice, double maxPrice);

    List<Product> findByCategory(Category category);

}
