package com.kludge.calculator.services;

// CalculatorService.java
import com.kludge.calculator.repository.CalculationResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    private final CalculationResultRepository calculationResultRepository;

    @Autowired
    public CalculatorService(CalculationResultRepository calculationResultRepository) {
        this.calculationResultRepository = calculationResultRepository;
    }

    public CalculationResult add(Integer num1, Integer num2) {
        int result = num1 + num2;
        String expression = num1 + " + " + num2;
        return saveCalculationResult(expression, result);
    }

    // Similar modifications for subtract, multiply, and divide methods...

    private CalculationResult saveCalculationResult(String expression, double result) {
        CalculationResult calculationResult = new CalculationResult(expression, result);
        return calculationResultRepository.save(calculationResult);
    }

    public Iterable<CalculationResult> getAllCalculations() {
        return calculationResultRepository.findAll();
    }
}

