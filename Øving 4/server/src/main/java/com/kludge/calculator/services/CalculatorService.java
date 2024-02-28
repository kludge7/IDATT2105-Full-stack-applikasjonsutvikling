package com.kludge.calculator.services;

import com.kludge.calculator.model.CalculationResult;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public CalculationResult add(Integer num1, Integer num2) {
        int result = num1 + num2;
        return new CalculationResult(result);
    }

    public CalculationResult subtract(Integer num1, Integer num2) {
        int result = num1 - num2;
        return new CalculationResult(result);
    }

    public CalculationResult multiply(Integer num1, Integer num2) {
        int result = num1 * num2;
        return new CalculationResult(result);
    }

    public CalculationResult divide(double num1, double num2) {
        double result = num1 / num2;
        return new CalculationResult(result);
    }
}
