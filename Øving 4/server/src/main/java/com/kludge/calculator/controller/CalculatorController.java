package com.kludge.calculator.controller;

import com.kludge.calculator.model.CalculationResult;
import com.kludge.calculator.services.CalculatorService;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/calculator")
@CrossOrigin(origins = "http://localhost:5173")
public class CalculatorController {
    private final CalculatorService calculatorService;
    Logger logger = LoggerFactory.getLogger(CalculatorController.class);
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
}
