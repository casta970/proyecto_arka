package com.arka.arkadcastano.domain.port.in;

import com.arka.arkadcastano.domain.model.Category;
import java.util.List;

public interface CategoryUseCase {
    List<Category> getAllCategories();
    Category getCategoryById(Long id);
    Category createCategory(Category category);
    Category updateCategory(Long id, Category category);
    void deleteCategory(Long id);
}