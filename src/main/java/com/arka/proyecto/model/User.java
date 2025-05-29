package com.arka.proyecto.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String name;

    @NotBlank(message = "El apellido no puede estar vacío")
    private String lastName;

    @NotBlank(message = "El número de teléfono no puede estar vacío")
    private String phoneNumber;

    @NotBlank(message = "El correo electrónico no puede estar vacío")
    @Email(message = "El correo electrónico no es válido")
    private String email;   

    @NotBlank(message = "La contraseña no puede estar vacía")
    private String password;

    boolean isAdmin;

    @JsonManagedReference(value = "user-order")
    @OneToMany(mappedBy="user")
    private List<Order> orders;

    @JsonManagedReference
    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Cart cart;

}
