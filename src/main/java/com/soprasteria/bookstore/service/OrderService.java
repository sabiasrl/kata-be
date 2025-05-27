package com.soprasteria.bookstore.service;

import com.soprasteria.bookstore.model.Order;
import com.soprasteria.bookstore.model.Cart;
import com.soprasteria.bookstore.model.CartItem;
import com.soprasteria.bookstore.repository.OrderRepository;
import com.soprasteria.bookstore.repository.CartRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;

    public OrderService(OrderRepository orderRepository, CartRepository cartRepository) {
        this.orderRepository = orderRepository;
        this.cartRepository = cartRepository;
    }

    @Transactional
    public Order checkout(Long cartId) {
        Cart cart = cartRepository.findById(cartId).orElseThrow();
        double total = cart.getItems().stream()
                .mapToDouble(item -> item.getBook().getPrice() * item.getQuantity())
                .sum();
        // Create a new list to avoid shared references
        // TODO clone
        java.util.List<CartItem> orderItems = new java.util.ArrayList<>();
        for (CartItem item : cart.getItems()) {
            orderItems.add(new CartItem(item.getBook(), item.getQuantity()));
        }
        Order order = new Order(orderItems, total);
        cart.getItems().clear();
        cartRepository.save(cart);
        return orderRepository.save(order);
    }
}
