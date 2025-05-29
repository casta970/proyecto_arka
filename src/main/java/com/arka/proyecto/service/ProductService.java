package com.arka.proyecto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.arka.proyecto.model.Category;
import com.arka.proyecto.model.Product;
import com.arka.proyecto.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
    
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
    
    public Product updateProduct(Long id, Product product) {
        Optional<Product> productExist = productRepository.findById(id);
        if(productExist.isPresent()) {
            product.setId(id);
            return productRepository.save(product);
        } else {
            return null;
        }
    }
    
    public boolean deleteProduct(Long id) {
        Optional<Product> productExist = productRepository.findById(id);
        if(productExist.isPresent()) {
            productRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public List<Product> getProductsByNameOrDescription(String text) {
        return productRepository.findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(text, text);
    }

    public List<Product> getAllProductsOrderByNameAsc() {
        return productRepository.findAllByOrderByNameAsc();
    }

    public List<Product> getProductsByPriceRange(double minPrice, double maxPrice) {
        return productRepository.findByPriceBetween(minPrice, maxPrice);
    }

    public List<Product> getProductsByCategoryId(Long categoryId) {
        Category category = categoryService.getCategoryById(categoryId);
        if (category == null) {
            return List.of();
        }
        return productRepository.findByCategory(category);
    }

}
