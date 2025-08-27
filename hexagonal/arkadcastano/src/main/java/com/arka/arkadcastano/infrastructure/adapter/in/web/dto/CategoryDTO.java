package com.arka.arkadcastano.infrastructure.adapter.in.web.dto;

public class CategoryDTO {
    private Long id;
    private String nombre;

    // Constructores
    public CategoryDTO() {}

    public CategoryDTO(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}