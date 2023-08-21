package com.foxminded.borisnij;

public class IntegerDivisionExerciseService {
    private final IntegerDivisionStepCache divisionStepCache;

    public IntegerDivisionExerciseService(IntegerDivisionStepCache divisionStepCache) {
        this.divisionStepCache = divisionStepCache;
    }

    public IntegerDivisionExercise getIntegerDivisionExercise(int dividend, int divisor) {
        return new IntegerDivisionExercise(dividend,
                                           divisor,
                                           divisionStepCalculator.calculateStepsForOperands(dividend, divisor));
    }
}
