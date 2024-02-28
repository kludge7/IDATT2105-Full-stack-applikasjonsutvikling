package com.kludge.calculator.model;

// CalculationResult.java
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CalculationResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String expression;
    private double result;

    public CalculationResult() {
    }

    public CalculationResult(String expression, double result) {
        this.expression = expression;
        this.result = result;
    }

    // Getters and setters
}