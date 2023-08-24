package com.foxminded.borisnij;

public class Task3IntegralDiv {
    public static void main(String[] args) {
        IntegerDivisionCalculator divisionCalculator = new CachingIntegerDivisionCalculator(new IntegerDivisionStepCache());
        IntegerDivisionSolution divisionExercise = divisionCalculator.calculateSolutionForOperands(
                Integer.parseInt("78945"),
                Integer.parseInt("4"));
        String solution = new IntegerDivisionExerciseFormattingService().format(divisionExercise);
        System.out.println(solution);
    }
}
