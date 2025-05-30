package com.soprasteria.bookstore.controller;

import com.soprasteria.bookstore.model.User;
import com.soprasteria.bookstore.service.UserService;
import com.soprasteria.bookstore.vo.UserVO;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserVO userVO) {
        try {
            User user = userService.register(userVO.getUsername(), userVO.getPassword());
            logger.info("User registered: {}", user.getUsername());
            return ResponseEntity.ok(user);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserVO userVO) {
        return userService.authenticate(userVO.getUsername(), userVO.getPassword())
                .<ResponseEntity<?>>map(user -> {
                    UserVO response = new UserVO();
                    response.setUsername(user.getUsername());
                    logger.info("User logged in: {}", user.getUsername());
                    return ResponseEntity.ok(response);
                })
                .orElseGet(() -> {
                    HashMap<String, String> error = new HashMap<>();
                    error.put("error", "Invalid credentials");
                    return ResponseEntity.status(401).body(error);
                });
    }
}
