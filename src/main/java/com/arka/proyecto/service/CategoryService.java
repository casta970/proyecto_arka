package com.arka.proyecto.service;

import org.springframework.stereotype.Service;

import com.arka.proyecto.model.Category;
import com.arka.proyecto.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

}
