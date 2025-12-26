package com.example.demo.dto;

public class EligibilityResponse {

    private boolean eligible;
    private String reason;

    public EligibilityResponse() {
    }

    public boolean isEligible() {
        return eligible;
    }

    public void setEligible(boolean eligible) {
        this.eligible = eligible;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
