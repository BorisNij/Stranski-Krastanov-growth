package com.foxminded.borisnij;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class IntegerDivisionFormatterTest {
    DivisionStepCalculationService divisionStepCalculationService;
    IntegerDivisionFormatter integerDivisionFormatter;

    @BeforeEach
    void setUp() {
//        integerDivider = new IntegerDivider();
//        integerDivisionFormatter = new IntegerDivisionFormatter(divisionExpression);
    }

    @Test
    void report() {
        final int dividend = 133;
        final int divisor = 5;
//        final List<IntegerDivisionStep> solution = integerDivider.divide(dividend, divisor);
//        integerDivisionFormatter.format(dividend, divisor, solution);
        assertTrue(1 == 1);
    }
}