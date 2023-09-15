package com.foxminded.borisnij;

public class Task3IntegralDiv {
    public static void main(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("The number of arguments cannot differ from 2");
        }
        try {
            int dividend = Integer.parseInt(args[0]);
            int divisor = Integer.parseInt(args[1]);
            if (dividend < 0) {
                throw new IllegalArgumentException("Negative dividend not allowed");
            }
            if (divisor < 1) {
                throw new IllegalArgumentException("Negative or zero divisor not allowed");
            }
            IntegerDivisionCalculator divisionCalculator = new CachingIntegerDivisionCalculator(new IntegerDivisionStepCache());
            IntegerDivisionSolutionDTO solution = new IntegerDivisionSolutionService(divisionCalculator).createSolutionForOperands(
                    dividend,
                    divisor);
            String divisionSolution = solution.formatWithFormatter(new IntegerDivisionSolutionFormatter.Builder().build());
            System.out.println(divisionSolution);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Non-integer arguments not allowed");
        }
    }
}
