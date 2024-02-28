package com.kludge.calculator.controller;

import com.kludge.calculator.model.CalculationResult;
import com.kludge.calculator.services.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/calculator")
@CrossOrigin(origins = "http://localhost:5173")
public class CalculatorController {
    private final CalculatorService calculatorService;
    Logger logger = LoggerFactory.getLogger(CalculatorController.class);
    @Autowired
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }
    @GetMapping("/add/{num1}/{num2}")
    public CalculationResult add(@PathVariable int num1, @PathVariable int num2) {
        logger.info(num1 + " + " + num2);
        return calculatorService.add(num1, num2);
    }
    @GetMapping("/subtract/{num1}/{num2}")
    public CalculationResult subtract(@PathVariable int num1, @PathVariable int num2) {
        logger.info(num1 + " - " + num2);
        return calculatorService.subtract(num1, num2);
    }
    @GetMapping("/multiply/{num1}/{num2}")
    public CalculationResult multiply(@PathVariable int num1, @PathVariable int num2) {
        logger.info(num1 + " * " + num2);
        return calculatorService.multiply(num1, num2);
    }
    @GetMapping("/divide/{num1}/{num2}")
    public CalculationResult divide(@PathVariable Double num1, @PathVariable Double num2) {
        logger.info(num1 + " / " + num2);
        return calculatorService.divide(num1, num2);
    }

    @GetMapping("/calculations")
    public Iterable<CalculationResult> getAllCalculations() {
        return calculatorService.getAllCalculations();
    }

    @PostMapping("/calculate")
    public CalculationResult calculate(@RequestBody String expression) {
        // Assume expression is like "num1 + num2" and parse it to perform the calculation
        // Example: extract num1, num2 and operator from the expression, then call the appropriate CalculatorService method
        // For simplicity, you can update this based on your specific expression handling logic
        // ...

        // For now, let's assume it's an addition for demonstration purposes
        int num1 = 5;
        int num2 = 3;

        return calculatorService.add(num1, num2);
    }
}
}
