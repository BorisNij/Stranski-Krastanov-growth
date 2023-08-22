package com.foxminded.borisnij;

public class Task3IntegralDiv {
    public static void main(String[] args) {
        DivisionStepCalculationService stepCalculator = new CachingDivisionStepCalculationService(new IntegerDivisionStepCache());
        IntegerDivisionExercise divisionExercise = new IntegerDivisionExerciseService(stepCalculator).getIntegerDivisionExercise(
                Integer.parseInt("78945"),
                Integer.parseInt("4"));
        String solution = new IntegerDivisionExerciseFormattingService().format(divisionExercise);
        System.out.println(solution);
    }
}
