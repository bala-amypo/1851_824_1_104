// File: src/main/java/com/example/demo/model/PolicyRule.java
package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "policy_rule")
public class PolicyRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String policyName;
    private String description;

    public PolicyRule() {}

    public PolicyRule(String policyName, String description) {
        this.policyName = policyName;
        this.description = description;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPolicyName() { return policyName; }
    public void setPolicyName(String policyName) { this.policyName = policyName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
