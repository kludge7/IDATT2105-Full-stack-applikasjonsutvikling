package com.kludge.calculation.services;

import com.kludge.calculation.dto.CalculationDto;
import com.kludge.calculation.model.Calculation;
import com.kludge.calculation.repository.CalculationRepository;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for managing calculations.
 * Provides functionality to evaluate mathematical expressions and manage calculation entities.
 */
@Service
public class CalculationService {

    private final CalculationRepository calculationRepository;
    private final UserService userService;

    /**
     * Constructs a CalculationService with necessary dependencies.
     */
    public CalculationService(CalculationRepository calculationRepository, UserService userService) {
        this.calculationRepository = calculationRepository;
        this.userService = userService;
    }

    /**
     * Evaluates a mathematical expression using a script engine.
     */  
    private double evaluateExpression(String expression) {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("graal.js"); 
        if (engine == null) {
            throw new IllegalStateException("Engine not found");
        }
        try {
            return ((Number) engine.eval(expression)).doubleValue();
        } catch (ScriptException e) {
            e.printStackTrace();
            return Double.NaN;
        }
    }
    

    /**
     * Evaluates a mathematical expression and creates a calculation entity.
     */
    public CalculationDto createCalculation(CalculationDto calculationDto) {
        Calculation calculation = new Calculation();
        calculation.setExpression(calculationDto.getExpression());
        calculation.setResult(evaluateExpression(calculationDto.getExpression()));
        calculation.setUser(userService.findByUsername(calculationDto.getUsername()));
    
        calculationRepository.save(calculation);
        calculationDto.setId(calculation.getId());
        calculationDto.setResult(calculation.getResult());
        return calculationDto;
    }

    /**
     * Get the 10 latest calculations made my a certain user
     */
    public List<CalculationDto> getLatestCalculations(String username) {
        return calculationRepository.findTop10ByUser_IdOrderByIdDesc((userService.findByUsername(username).getId())).stream().map(calculation -> {
            CalculationDto dto = new CalculationDto();
            dto.setExpression(calculation.getExpression());
            dto.setResult(calculation.getResult());
            return dto;
        }).collect(Collectors.toList());
    }
}
