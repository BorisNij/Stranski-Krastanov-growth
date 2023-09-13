package com.foxminded.borisnij;

public class Task3IntegralDiv {
    public static void main(String[] args) {
        IntegerDivisionCalculator divisionCalculator = new CachingIntegerDivisionCalculator(new IntegerDivisionStepCache());
        IntegerDivisionSolutionDTO solution = new IntegerDivisionSolutionService(divisionCalculator).createSolutionForOperands(
                Integer.parseInt("78945"),
                Integer.parseInt("4"));
        String divisionSolution = solution.formatWithFormatter(new IntegerDivisionSolutionFormatter(new StringEdgeModifier()));
        System.out.println(divisionSolution);
    }
}
