package com.arka.proyecto.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arka.proyecto.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByProducts_Id(Long productId);

    List<Order> findByDateBetween(Date startDate, Date endDate);

    List<Order> findByUser_Id(Long userId);
}