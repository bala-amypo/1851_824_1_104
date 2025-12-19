// RegisterResponse.java
package com.example.demo.dto;

public record RegisterResponse(
    Long id,
    String username,
    String email,
    String message
) {}
