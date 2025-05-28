package com.soprasteria.bookstore.model;

import jakarta.persistence.*;
import java.util.List;
import lombok.Data;

@Entity
@Table(name = "orders")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<com.soprasteria.bookstore.model.CartItem> items;

    private Double total;

    public Order() {}
    public Order(List<CartItem> items, Double total) {
        this.items = items;
        this.total = total;
    }
}
