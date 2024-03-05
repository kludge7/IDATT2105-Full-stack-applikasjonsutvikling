package com.kludge.calculation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kludge.calculation.model.Calculation;
import java.util.List;

/**
 * Repository interface for Calculation entities.
 */
public interface CalculationRepository extends JpaRepository<Calculation, Integer> {

    /**
     * Finds all calculations associated with a given username.
     */
    List<Calculation> findByUserId(int id);

    // Add a method to find the last 10 calculations for a specific user, sorted by ID
    List<Calculation> findTop10ByUser_IdOrderByIdDesc(Long userId); 

}
