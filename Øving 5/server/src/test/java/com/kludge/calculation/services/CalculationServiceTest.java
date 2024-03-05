package com.kludge.calculation.services;

import com.kludge.calculation.dto.CalculationDto;
import com.kludge.calculation.model.Calculation;
import com.kludge.calculation.model.User;
import com.kludge.calculation.repository.CalculationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class CalculationServiceTest {

    @Mock
    private CalculationRepository calculationRepository;

    @InjectMocks
    private CalculationService calculationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllCalculationsShouldReturnData() {
        Calculation calculation1 = new Calculation();
        User user1 = new User();
        user1.setUsername("user1");
        calculation1.setUser(user1);
        calculation1.setId(1L);
        calculation1.setExpression("1 + 1");
        calculation1.setResult(2);

        Calculation calculation2 = new Calculation();
        User user2 = new User();
        user2.setUsername("user2");
        calculation2.setUser(user2);
        calculation2.setId(2L);
        calculation2.setExpression("2 + 2");
        calculation2.setResult(4);

        when(calculationRepository.findAll()).thenReturn(Arrays.asList(calculation1, calculation2));

        List<CalculationDto> calculations = calculationService.getAllCalculations();

        assertEquals(2, calculations.size());
        assertEquals("1 + 1", calculations.get(0).getExpression());
        assertEquals(2, calculations.get(0).getResult());
    }
}
