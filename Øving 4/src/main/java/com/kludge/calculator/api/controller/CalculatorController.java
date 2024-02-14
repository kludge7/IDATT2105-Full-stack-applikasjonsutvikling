package main.java.com.kludge.calculator.api.controller;

import main.java.com.kludge.calculator.api.model.Calculator;
import main.java.com.kludge.calculator.services.CalculatorService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class CalculatorController {
    private CalculatorService calculatorService;
    
    @Autowired
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }
    @GetMapping
    public Calculator getCalculator(@RequestParam Integer id) { 
        return calculatorService.getCalculator(id);
    }
}
