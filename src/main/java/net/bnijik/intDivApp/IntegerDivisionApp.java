package net.bnijik.intDivApp;

import net.bnijik.intDivApp.calculator.IntegerDivisionCalculator;
import net.bnijik.intDivApp.calculator.IntegerDivisionCalculatorImpl;
import net.bnijik.intDivApp.dto.IntegerDivisionSolutionDTO;
import net.bnijik.intDivApp.formatter.IntegerDivisionSolutionFormatterImpl;
import net.bnijik.intDivApp.service.IntegerDivisionSolutionServiceImpl;

public class IntegerDivisionApp {
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
            IntegerDivisionCalculator divisionCalculator = new IntegerDivisionCalculatorImpl();
            IntegerDivisionSolutionDTO solution = new IntegerDivisionSolutionServiceImpl(divisionCalculator).createSolutionForOperands(
                    dividend,
                    divisor);
            String divisionSolution = solution.formatWithFormatter(new IntegerDivisionSolutionFormatterImpl.Builder().build());
            System.out.println(divisionSolution);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Non-integer arguments not allowed");
        }
    }
}
