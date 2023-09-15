package com.foxminded.borisnij;

import com.foxminded.borisnij.calculator.CachingIntegerDivisionCalculator;
import com.foxminded.borisnij.calculator.IntegerDivisionCalculator;
import com.foxminded.borisnij.calculator.IntegerDivisionStepCache;
import com.foxminded.borisnij.dto.IntegerDivisionSolutionDTO;
import com.foxminded.borisnij.formatter.IntegerDivisionSolutionFormatterImpl;
import com.foxminded.borisnij.service.IntegerDivisionSolutionServiceImpl;

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
