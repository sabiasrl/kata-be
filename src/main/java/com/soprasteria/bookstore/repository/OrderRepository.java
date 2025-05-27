package com.soprasteria.bookstore.repository;

import com.soprasteria.bookstore.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    // Additional query methods if needed
}
