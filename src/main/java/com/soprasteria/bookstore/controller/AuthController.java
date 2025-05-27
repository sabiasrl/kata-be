package com.soprasteria.bookstore.controller;

import com.soprasteria.bookstore.model.User;
import com.soprasteria.bookstore.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> body) {
        try {
            User user = userService.register(body.get("username"), body.get("password"));
            return ResponseEntity.ok(user);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
        return userService.authenticate(body.get("username"), body.get("password"))
                .map(user -> ResponseEntity.ok("Login successful"))
                .orElseGet(() -> ResponseEntity.status(401).body("Invalid credentials"));
    }
}
