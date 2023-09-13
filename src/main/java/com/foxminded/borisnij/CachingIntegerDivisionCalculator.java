package com.foxminded.borisnij;

import java.util.List;

public class CachingIntegerDivisionCalculator extends IntegerDivisionCalculator {

    private final IntegerDivisionStepCache stepCache;

    public CachingIntegerDivisionCalculator(IntegerDivisionStepCache stepCache) {
        this.stepCache = stepCache;
    }

    @Override
    public List<IntegerDivisionStep> calculateDivisionStepsForOperands(int dividend, int divisor) {
        List<IntegerDivisionStep> divisionSteps = stepCache.getIntegerDivisionStepsForOperands(dividend, divisor);
        if (divisionSteps.isEmpty()) {
            divisionSteps = super.calculateDivisionStepsForOperands(dividend, divisor);
            stepCache.addIntegerDivisionStepsForOperands(dividend, divisor, divisionSteps);
        }
        return divisionSteps;
    }
}
