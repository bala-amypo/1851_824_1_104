// AuthResponse.java
package com.example.demo.dto;

public record AuthResponse(
    String token,
    String message
) {}
