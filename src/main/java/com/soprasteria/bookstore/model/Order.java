package com.soprasteria.bookstore.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
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
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public List<CartItem> getItems() { return items; }
    public void setItems(List<CartItem> items) { this.items = items; }
    public Double getTotal() { return total; }
    public void setTotal(Double total) { this.total = total; }
}
