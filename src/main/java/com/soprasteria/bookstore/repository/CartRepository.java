package com.soprasteria.bookstore.repository;

import com.soprasteria.bookstore.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
    // Additional query methods if needed
}
