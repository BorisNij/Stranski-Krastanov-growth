package com.foxminded.borisnij;

import java.util.List;

public class CachingDivisionStepCalculationService extends DivisionStepCalculationService {

    private final IntegerDivisionStepCache stepCache;

    public CachingDivisionStepCalculationService(IntegerDivisionStepCache stepCache) {
        this.stepCache = stepCache;
    }

    @Override
    public List<IntegerDivisionStep> calculateStepsForOperands(int dividend, int divisor) {
        List<IntegerDivisionStep> divisionSteps = this.stepCache.getIntegerDivisionStepsForOperands(dividend, divisor);
        if (divisionSteps.isEmpty()) {
            divisionSteps = super.calculateStepsForOperands(dividend, divisor);
            this.stepCache.addIntegerDivisionStepsForOperands(dividend, divisor, divisionSteps);
        }
        return divisionSteps;
    }
}
