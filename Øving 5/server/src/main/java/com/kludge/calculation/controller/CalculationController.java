package com.kludge.calculation.controller;

import org.springframework.web.bind.annotation.*;
import com.kludge.calculation.dto.CalculationDto;
import com.kludge.calculation.services.CalculationService;

import java.util.List;

/**
 * REST controller for handling calculation-related requests.
 * Provides endpoints for creating and retrieving calculations.
 */
@RestController
@RequestMapping("/api/calculations")
@CrossOrigin(origins = "*")
public class CalculationController {

    private final CalculationService calculationService;

    /**
     * Class constructor.
     */
    public CalculationController(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    /**
     * Creates a new calculation based on the provided calculationDto. 
     * Currently this calculationDto only contains the expression
     */
    @PostMapping
    public CalculationDto createCalculation(@RequestBody CalculationDto calculationDto) {
        return calculationService.createCalculation(calculationDto);
    }

    /**
     * Retrieves all calculations.
     */
    @GetMapping
    public List<CalculationDto> getAllCalculations() {
        return calculationService.getAllCalculations();
    }

    @GetMapping("/latest")
    public List<CalculationDto> getLatestCalculations(@RequestParam String username) {
        return calculationService.getLatestCalculations(username);
    }

}
