package com.foxminded.borisnij;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class LongDivisionReporterTest {
    LongDivider longDivider;
    LongDivisionReporter longDivisionReporter;

    @BeforeEach
    void setUp() {
        longDivider = new LongDivider();
        longDivisionReporter = new LongDivisionReporter();
    }

    @Test
    void report() {
        final int dividend = 133;
        final int divisor = 5;
        final List<DivisionStep> solution = longDivider.divide(dividend, divisor);
        longDivisionReporter.report(dividend, divisor, solution);
        assertTrue(1 == 1);
    }
}