package com.arka.proyecto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.arka.proyecto.model.Cart;
import com.arka.proyecto.repository.CartRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;

    public List<Cart> getAbandonedCarts() {
        return cartRepository.findByIsActive(false);
    }

}