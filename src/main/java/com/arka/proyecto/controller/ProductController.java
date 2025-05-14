package com.arka.proyecto.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arka.proyecto.model.Product;
import com.arka.proyecto.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    // @PostMapping
    // public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product) {
    //     Product createdProduct = productService.createProduct(product);
    //     return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    // }

    // @PutMapping("/{id}")
    // public ResponseEntity<Product> updateProduct(@PathVariable Long id, @Valid @RequestBody Product product) {
    //     Product updatedProduct = productService.updateProduct(id, product);
    //     return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    // }

    // @DeleteMapping("/{id}")
    // public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
    //     productService.deleteProduct(id);
    //     return new ResponseEntity<>(HttpStatus.NO_CONTENT);

}
