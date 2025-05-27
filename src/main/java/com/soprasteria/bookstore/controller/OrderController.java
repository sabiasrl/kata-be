package com.soprasteria.bookstore.controller;

import com.soprasteria.bookstore.model.Order;
import com.soprasteria.bookstore.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/checkout")
    public ResponseEntity<Order> checkout(@RequestParam Long cartId) {
        Order order = orderService.checkout(cartId);
        return ResponseEntity.ok(order);
    }
}
