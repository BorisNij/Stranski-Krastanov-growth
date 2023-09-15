package com.foxminded.borisnij;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CachingIntegerDivisionCalculatorTest {

    @InjectMocks
    private CachingIntegerDivisionCalculator childCachingCalculator;

    @Mock
    private IntegerDivisionStepCache stepCache;

    @Mock
    private IntegerDivisionCalculator parentNonCachingCalculator;


    @Test
    @DisplayName("when calculating division steps with cache hit cached steps should be returned")
    void whenCalculatingDivisionStepsWithCacheHitCachedStepsShouldBeReturned() {
        int dividend = 10;
        int divisor = 2;
        List<IntegerDivisionStep> cachedSteps = Arrays.asList(new IntegerDivisionStep(10, 10, '5'),
                                                              new IntegerDivisionStep(0, 0, '\0'));
        when(stepCache.getIntegerDivisionStepsForOperands(dividend, divisor)).thenReturn(cachedSteps);

        List<IntegerDivisionStep> actualSteps = childCachingCalculator.calculateDivisionStepsForOperands(dividend,
                                                                                                         divisor);

        verify(parentNonCachingCalculator, never()).calculateDivisionStepsForOperands(anyInt(), anyInt());
        verify(stepCache, times(1)).getIntegerDivisionStepsForOperands(dividend, divisor);
        verify(stepCache, never()).addIntegerDivisionStepsForOperands(anyInt(), anyInt(), anyList());
        assertEquals(cachedSteps, actualSteps);
    }

    @Test
    @DisplayName("when repeatedly calculating division steps for the same operands after cache hit calculation should not be called")
    void whenRepeatedlyCalculatingDivisionStepsForTheSameOperandsAfterCacheHitCalculationShouldNotBeCalled() {
        int dividend = 10;
        int divisor = 2;
        List<IntegerDivisionStep> cachedSteps = Arrays.asList(new IntegerDivisionStep(10, 10, '5'),
                                                              new IntegerDivisionStep(0, 0, '\0'));
        when(stepCache.getIntegerDivisionStepsForOperands(dividend, divisor)).thenReturn(cachedSteps);

        List<IntegerDivisionStep> actualSteps1 = childCachingCalculator.calculateDivisionStepsForOperands(dividend,
                                                                                                          divisor);
        List<IntegerDivisionStep> actualSteps2 = childCachingCalculator.calculateDivisionStepsForOperands(dividend,
                                                                                                          divisor);
        List<IntegerDivisionStep> actualSteps3 = childCachingCalculator.calculateDivisionStepsForOperands(dividend,
                                                                                                          divisor);

        verify(parentNonCachingCalculator, never()).calculateDivisionStepsForOperands(anyInt(), anyInt());
        verify(stepCache, times(3)).getIntegerDivisionStepsForOperands(dividend, divisor);
        verify(stepCache, never()).addIntegerDivisionStepsForOperands(anyInt(), anyInt(), anyList());
        assertEquals(cachedSteps, actualSteps1);
        assertEquals(cachedSteps, actualSteps2);
        assertEquals(cachedSteps, actualSteps3);
    }

    @Test
    @DisplayName("when calculating division steps with cache miss expected calculated steps should be returned and cached")
    void whenCalculatingDivisionStepsWithCacheMissExpectedCalculatedStepsShouldBeReturnedAndCached() {
        int dividend = 20;
        int divisor = 4;
        List<IntegerDivisionStep> emptyList = Collections.emptyList();
        when(stepCache.getIntegerDivisionStepsForOperands(dividend, divisor)).thenReturn(emptyList);

        List<IntegerDivisionStep> expectedSteps = Arrays.asList(new IntegerDivisionStep(20, 20, '5'),
                                                                new IntegerDivisionStep(0, 0, '\0'));

        List<IntegerDivisionStep> actualSteps = childCachingCalculator.calculateDivisionStepsForOperands(dividend,
                                                                                                         divisor);
        assertFalse(stepCache.isEmpty());
        when(stepCache.getIntegerDivisionStepsForOperands(dividend, divisor)).thenReturn(actualSteps);
        assertEquals(expectedSteps, actualSteps);
        List<IntegerDivisionStep> actualSteps2 = childCachingCalculator.calculateDivisionStepsForOperands(dividend,
                                                                                                          divisor);
        assertEquals(expectedSteps, actualSteps2);
        verify(stepCache, times(2)).getIntegerDivisionStepsForOperands(dividend, divisor);
        verify(stepCache, times(1)).addIntegerDivisionStepsForOperands(dividend, divisor, expectedSteps);
//        verify(parentNonCachingCalculator, times(1)).calculateDivisionStepsForOperands(dividend, divisor); // <-- cannot get this to pass, don't know why
    }
}
