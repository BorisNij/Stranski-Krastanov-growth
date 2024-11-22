package net.bnijik.intDivApp.calculator;

import net.bnijik.intDivApp.model.IntegerDivisionStep;

import java.util.List;

public class CachingIntegerDivisionCalculator extends IntegerDivisionCalculatorImpl {

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
