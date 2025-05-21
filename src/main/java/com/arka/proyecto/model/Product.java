package com.arka.proyecto.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String name;

    @NotBlank(message = "La marca no puede estar vacía")
    private String brand;

    @Min(value = 0, message = "El stock no puede ser menor a cero")
    @NotNull(message = "El stock no puede estar vacío")
    private int stock;

    @Min(value = 0, message = "El precio no puede ser menor a cero")
    @NotNull(message = "El precio no puede estar vacío")
    private double price;

    @Column(columnDefinition = "TEXT")
    @NotBlank(message = "La descripción no puede estar vacía")
    private String description;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name="order_has_products",
            joinColumns = @JoinColumn(name="product_id"),
            inverseJoinColumns = @JoinColumn(name="order_id")
    )
    private List<Order> orders;

    @JsonBackReference(value = "user-order")
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

}
