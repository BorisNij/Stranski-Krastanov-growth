package com.foxminded.borisnij;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class IntegerDivisionStepCacheTest {

    private IntegerDivisionStepCache cache;

    @BeforeEach
    void setUp() {
        cache = new IntegerDivisionStepCache();
    }

    @Test
    @DisplayName("When adding and getting integer division steps the retrieved steps should match the added steps")
    void whenAddingAndGettingIntegerDivisionStepsTheRetrievedStepsShouldMatchTheAddedSteps() {
        int dividend = 10;
        int divisor = 2;
        List<IntegerDivisionStep> steps = new ArrayList<>();
        steps.add(new IntegerDivisionStep(5, 0, '5'));

        cache.addIntegerDivisionStepsForOperands(dividend, divisor, steps);

        List<IntegerDivisionStep> retrievedSteps = cache.getIntegerDivisionStepsForOperands(dividend, divisor);

        assertEquals(steps, retrievedSteps);
    }

    @Test
    @DisplayName("When checking if integer division steps exist the correct result should be returned")
    void whenCheckingIfIntegerDivisionStepsExistTheCorrectResultShouldBeReturned() {
        int dividend = 20;
        int divisor = 4;
        List<IntegerDivisionStep> steps = new ArrayList<>();
        steps.add(new IntegerDivisionStep(5, 0, '5'));

        assertFalse(cache.containsIntegerDivisionStepsForOperands(dividend, divisor));
        cache.addIntegerDivisionStepsForOperands(dividend, divisor, steps);
        assertTrue(cache.containsIntegerDivisionStepsForOperands(dividend, divisor));
    }

    @Test
    @DisplayName("When invalidating the cache it should be empty")
    void whenInvalidatingTheCacheItShouldBeEmpty() {
        int dividend = 8;
        int divisor = 2;
        List<IntegerDivisionStep> steps = new ArrayList<>();
        steps.add(new IntegerDivisionStep(4, 0, '4'));

        cache.addIntegerDivisionStepsForOperands(dividend, divisor, steps);

        assertTrue(cache.containsIntegerDivisionStepsForOperands(dividend, divisor));

        cache.invalidate();

        assertFalse(cache.containsIntegerDivisionStepsForOperands(dividend, divisor));
    }
}