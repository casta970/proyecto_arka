package com.arka.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arka.proyecto.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
