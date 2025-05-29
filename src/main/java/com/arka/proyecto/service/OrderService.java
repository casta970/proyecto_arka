package com.arka.proyecto.service;

import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Service;

import com.arka.proyecto.model.Order;
import com.arka.proyecto.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getOrdersByProductId(Long productId) {
        return orderRepository.findByProducts_Id(productId);
    }

    public List<Order> getOrdersByDateRange(String startDate, String endDate) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date start = sdf.parse(startDate);
            Date end = sdf.parse(endDate);
            return orderRepository.findByDateBetween(start, end);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Formato inválido de fecha", e);
        }
    }

    public List<Order> getOrdersByUserId(Long userId) {
        return orderRepository.findByUser_Id(userId);
    }

}
