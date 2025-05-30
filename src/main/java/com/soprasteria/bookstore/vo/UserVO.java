package com.soprasteria.bookstore.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class UserVO {
    @JsonIgnore
    private Long id;
    private String username;
    private String password;
    @JsonIgnore
    private String role;
}
