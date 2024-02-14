package com.kludge.calculator.controller;

import com.kludge.calculator.model.CalculationResult;
import com.kludge.calculator.services.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/calculator")
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
}
