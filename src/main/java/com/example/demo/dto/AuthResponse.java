package com.example.demo.dto;

public class AuthResponse {

    private String email;
    private Long userId;
    private String role;
    private String token;

    public AuthResponse() {
    }

    public AuthResponse(String email, Long userId, String role, String token) {
        this.email = email;
        this.userId = userId;
        this.role = role;
        this.token = token;
    }

    // Getters and Setters
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }
}
