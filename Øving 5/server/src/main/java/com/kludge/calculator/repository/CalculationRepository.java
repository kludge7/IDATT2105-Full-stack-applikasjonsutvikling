package com.kludge.calculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kludge.calculator.entity.Calculation;

public interface CalculationRepository extends JpaRepository<Calculation, Long> {
    // your repository methods
}