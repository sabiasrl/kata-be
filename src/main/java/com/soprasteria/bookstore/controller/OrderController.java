package com.soprasteria.bookstore.controller;

import com.soprasteria.bookstore.model.Order;
import com.soprasteria.bookstore.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/checkout")
    @Operation(summary = "Checkout cart and create order", security = @SecurityRequirement(name = "basicAuth"))
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Order created"),
        @ApiResponse(responseCode = "401", description = "Unauthorized - user is not authenticated"),
        @ApiResponse(responseCode = "403", description = "Forbidden - user does not have the required role"),
        @ApiResponse(responseCode = "404", description = "Cart not found")
    })
    public ResponseEntity<Order> checkout(@RequestParam Long cartId) {
        Order order = orderService.checkout(cartId);
        if (order == null) {
            logger.info("Checkout failed: cartId={} not found", cartId);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cart not found");
        }
        logger.info("Order created for cartId={}, orderId={}", cartId, order.getId());
        return ResponseEntity.ok(order);
    }
}
