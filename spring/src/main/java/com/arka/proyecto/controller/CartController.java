package com.arka.proyecto.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arka.proyecto.model.Cart;
import com.arka.proyecto.service.CartService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/carts")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @RequestMapping("/abandoned")
    public ResponseEntity<List<Cart>> getAbandonedCarts() {
        List<Cart> abandonedCarts = cartService.getAbandonedCarts();
        return new ResponseEntity<>(abandonedCarts, HttpStatus.OK);
    }

}
