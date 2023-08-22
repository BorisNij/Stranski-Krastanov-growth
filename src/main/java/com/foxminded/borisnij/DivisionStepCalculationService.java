package com.foxminded.borisnij;

import java.util.ArrayList;
import java.util.List;

public class DivisionStepCalculationService {


    public List<IntegerDivisionStep> calculateStepsForOperands(int dividend, int divisor) {
        if (divisor < 1) {
            throw new IllegalArgumentException("Negative or zero divisor not allowed");
        }

        if (dividend < 0) {
            throw new IllegalArgumentException("Negative dividend not allowed");
        }

        List<IntegerDivisionStep> steps = new ArrayList<>();

        if (dividend == 0) {
            updateSteps(steps, 0, 0, '0', 0);
            updateSteps(steps, 0, 0, '\0', 0);
            return steps;
        }

        String dividendStr = String.valueOf(dividend);
        int partialDividend = 0;

        if (dividendStr.length() <= String.valueOf(divisor).length() && dividend < divisor) {
            updateSteps(steps, dividend, 0, '0', dividendStr.length() - 1);
            updateSteps(steps, dividend, 0, '\0', dividendStr.length() - 1);
            return steps;
        }

        for (int i = 0; i < dividendStr.length(); i++) {
            int dividendDigit = Character.getNumericValue(dividendStr.charAt(i));
            partialDividend = (partialDividend << 3) + (partialDividend << 1) + dividendDigit;

            if (partialDividend >= divisor) {
                int quotientDigit = partialDividend / divisor;
                int divisorMultiple = quotientDigit * divisor;
                updateSteps(steps, partialDividend, divisorMultiple, Character.forDigit(quotientDigit, 10), i);

                partialDividend -= divisorMultiple;
            } else if (!steps.isEmpty()) {
                updateSteps(steps, partialDividend, 0, Character.forDigit(0, 10), i);
            }
        }

        updateSteps(steps, partialDividend, 0, '\0', dividendStr.length() - 1);
        return steps;
    }

    private void updateSteps(List<IntegerDivisionStep> steps,
                             int partialDividend,
                             int divisorMultiple,
                             char quotientDigit) {
        updateSteps(steps, partialDividend, divisorMultiple, quotientDigit, -1);
    }

    private void updateSteps(List<IntegerDivisionStep> steps,
                             int partialDividend,
                             int divisorMultiple,
                             char quotientDigit,
                             int rightmostPartialDividendDigitIndex) {
        steps.add(new IntegerDivisionStep(partialDividend,
                                          divisorMultiple,
                                          quotientDigit,
                                          rightmostPartialDividendDigitIndex));
    }
}
