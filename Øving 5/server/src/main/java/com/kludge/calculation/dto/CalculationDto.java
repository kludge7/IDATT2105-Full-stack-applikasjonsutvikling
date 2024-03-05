package com.kludge.calculation.dto;

import com.kludge.calculation.model.User;

/**
 * Data Transfer Object for carrying calculation data between processes.
 * It encapsulates the calculation details including the expression, result, and associated user ID.
 */
public class CalculationDto {
    private Long id;
    private String expression;
    private double result;
    private User user;
    private String username;

    // Standard getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
