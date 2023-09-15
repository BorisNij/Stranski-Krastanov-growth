package com.foxminded.borisnij;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IntegerDivisionCalculator {


    private static char getQuotientDigitChar(int quotientDigit) {
        return Character.forDigit(quotientDigit, 10);
    }

    public List<IntegerDivisionStep> calculateDivisionStepsForOperands(int dividend, int divisor) {
        if (divisor < 1) {
            throw new IllegalArgumentException("Negative or zero divisor not allowed");
        }

        if (dividend < 0) {
            throw new IllegalArgumentException("Negative dividend not allowed");
        }

        List<IntegerDivisionStep> steps = new ArrayList<>();

        if (dividend == 0) {
            updateSteps(steps, 0, 0, '0');
            updateSteps(steps, 0, 0, '\0');
            return Collections.unmodifiableList(steps);
        }

        if (dividend < divisor) {
            updateSteps(steps, dividend, 0, '0');
            updateSteps(steps, dividend, 0, '\0');
            return Collections.unmodifiableList(steps);
        }

        String dividendStr = String.valueOf(dividend);
        int partialDividend = 0;
        for (int i = 0; i < dividendStr.length(); i++) {
            int dividendDigit = Character.getNumericValue(dividendStr.charAt(i));
            partialDividend = (partialDividend << 3) + (partialDividend << 1) + dividendDigit;

            if (partialDividend >= divisor) {
                int quotientDigit = partialDividend / divisor;
                int divisorMultiple = quotientDigit * divisor;
                updateSteps(steps, partialDividend, divisorMultiple, getQuotientDigitChar(quotientDigit));

                partialDividend -= divisorMultiple;
            } else if (!steps.isEmpty()) {
                updateSteps(steps, partialDividend, 0, getQuotientDigitChar(0));
            }
        }

        updateSteps(steps, partialDividend, 0, '\0');
        return Collections.unmodifiableList(steps);
    }

    private void updateSteps(List<IntegerDivisionStep> steps,
                             int partialDividend,
                             int divisorMultiple,
                             char quotientDigit) {
        steps.add(new IntegerDivisionStep(partialDividend, divisorMultiple, quotientDigit));
    }
}
