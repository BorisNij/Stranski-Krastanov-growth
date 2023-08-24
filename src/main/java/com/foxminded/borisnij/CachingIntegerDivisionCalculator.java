package com.foxminded.borisnij;

import java.util.List;

public class CachingIntegerDivisionCalculator extends IntegerDivisionCalculator {

    private final IntegerDivisionStepCache stepCache;

    public CachingIntegerDivisionCalculator(IntegerDivisionStepCache stepCache) {
        this.stepCache = stepCache;
    }

    @Override
    public IntegerDivisionSolution calculateSolutionForOperands(int dividend, int divisor) {
        List<IntegerDivisionStep> divisionSteps = this.stepCache.getIntegerDivisionStepsForOperands(dividend, divisor);
        if (divisionSteps.isEmpty()) {
            divisionSteps = super.calculateSolutionForOperands(dividend, divisor).getDivisionSteps();
            this.stepCache.addIntegerDivisionStepsForOperands(dividend, divisor, divisionSteps);
        }
        return new IntegerDivisionSolution(dividend, divisor, divisionSteps);
    }
}
