package com.arka.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arka.proyecto.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario

}
