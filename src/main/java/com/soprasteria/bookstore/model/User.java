package com.soprasteria.bookstore.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "\"user\"")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String role = "USER";
    public User() {}
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
