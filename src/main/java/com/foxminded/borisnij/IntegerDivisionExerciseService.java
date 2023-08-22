package com.foxminded.borisnij;

public class IntegerDivisionExerciseService {
    private final DivisionStepCalculationService calculationService;

    public IntegerDivisionExerciseService(DivisionStepCalculationService calculationService) {
        this.calculationService = calculationService;
    }


    public IntegerDivisionExercise getIntegerDivisionExercise(int dividend, int divisor) {
        return new IntegerDivisionExercise(dividend,
                                           divisor,
                                           this.calculationService.calculateStepsForOperands(dividend, divisor));
    }
}
