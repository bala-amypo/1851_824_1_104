package com.example.demo.dto;

public class AuthResponse {
    private boolean eligible;
    private String message;

    public boolean isEligible() { return eligible; }
    public void setEligible(boolean eligible) { this.eligible = eligible; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
